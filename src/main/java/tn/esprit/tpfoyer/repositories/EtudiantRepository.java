package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Chambre;
import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
    public List<Etudiant> findByEcoleAndDateNaissanceGreaterThan(String ecole, Date dateNaissance);

    @Query("SELECT distinct (ch) FROM Chambre ch " +
            "INNER JOIN ch.reservations r " +
            "INNER JOIN r.etudiants e " +
            "WHERE e.cin=:cin " )
    Chambre trouverChselonEt(Long cin);
}
