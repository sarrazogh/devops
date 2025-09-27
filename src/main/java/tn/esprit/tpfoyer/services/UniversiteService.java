package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Universite;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UniversiteService implements IUniversiteService {
    @Autowired
    UniversiteRepository universiteRepository;
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }
    public Universite retrieveUniversite(Long UniversiteId) {
        return universiteRepository.findById(UniversiteId).get();
    }
    public Universite addUniversite(Universite c) {
        return universiteRepository.save(c);
    }
    public void removeUniversite(Long UniversiteId) {
        universiteRepository.deleteById(UniversiteId);
    }
    public Universite modifyUniversite(Universite Universite) {
        return universiteRepository.save(Universite);
    }
}
