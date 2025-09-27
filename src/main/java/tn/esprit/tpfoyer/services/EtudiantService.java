package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EtudiantService implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }
    public Etudiant retrieveEtudiant(Long etudiantId) {
        return etudiantRepository.findById(etudiantId).get();
    }
    public Etudiant addEtudiant(Etudiant c) {
        return etudiantRepository.save(c);
    }
    public void removeEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    @Override
    public List<Etudiant> searchEtudiantbyEcoleAndDateNaissance(String ecole, Date dateNaissance) {
        return etudiantRepository.findByEcoleAndDateNaissanceGreaterThan(ecole,dateNaissance);
    }
    @Override
    public Chambre trouverChselonEt(Long cin){
        Chambre ch = etudiantRepository.trouverChselonEt(cin);
        return ch;
    }

}
