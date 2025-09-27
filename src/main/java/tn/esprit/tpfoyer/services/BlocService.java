package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.repositories.BlocRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class BlocService implements IBlocService{
    @Autowired
    BlocRepository blocRepository;

    @Scheduled(cron = "0 * * * * *")
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> listB = blocRepository.findAll();
        for (Bloc b: listB) {
            log.info("Bloc :" + b);
        }
        return listB;     }
    public Bloc retrieveBloc(Long BlocId) {
        return blocRepository.findById(BlocId).get();
    }
    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }
    public void removeBloc(Long BlocId) {
        blocRepository.deleteById(BlocId);
    }
    public Bloc modifyBloc(Bloc Bloc) {
        return blocRepository.save(Bloc);
    }

}
