package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.repositories.BlocRepository;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j


public class ChambreService implements IChambreService {

    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    private BlocRepository blocRepository;

    @Override
    @Scheduled(cron = "*/10 * * * * *") // Toutes les 10 secondes
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> listC = chambreRepository.findAll();
        for (Chambre c: listC) {
            log.info("Chambre - ID: {}, Numero: {}, Type: {}",
                    c.getIdChambre(), c.getNumeroChambre(), c.getTypeC());
        }
        return listC;
    }
    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }
    @Override
    public List<Chambre> searchChambrepartype(TypeChambre tch) {
        return chambreRepository.findAllByTypeChambre(tch);
    }
    @Override
    public Chambre searchChambreparnumerochambre(Long numch) {
        return chambreRepository.findChambreByNumeroChambre(numch);
    }
    @Override
    public Chambre addProjetAndProjetDetailAndAssign(Chambre ch) {
        return chambreRepository.save(ch);

    }
    @Scheduled(fixedRate = 60000) // toutes les minutes
    public void listeChambresParBloc() {
        List<Bloc> blocs = blocRepository.findAll();

        for (Bloc bloc : blocs) {
            log.info("Bloc => {} ayant une capacité {}", bloc.getNomBloc(), bloc.getCapaciteBloc());
            List<Chambre> chambres = chambreRepository.findByBlocs(bloc);

            if (chambres.isEmpty()) {
                log.info("Pas de chambre disponible dans ce bloc");
            } else {
                log.info("La liste des chambres pour ce bloc:");
                for (Chambre chambre : chambres) {
                    log.info("NumChambre: {} type: {}", chambre.getNumeroChambre(), chambre.getTypeC());
                }
            }

            log.info("******************");
        }
    }

    @Scheduled(cron = "0 */5 * * * *") // toutes les 5 minutes
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();
        int total = chambres.size();

        log.info("Nombre total des chambres: {}", total);

        for (TypeChambre type : TypeChambre.values()) {
            long count = chambres.stream()
                    .filter(c -> c.getTypeC() == type)
                    .count();

            double pourcentage = total == 0 ? 0.0 : ((double) count / total) * 100.0;

            log.info("Le pourcentage des chambres pour le type {} est égale à {}", type, pourcentage);
        }
    }
}
