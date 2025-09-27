package tn.esprit.tpfoyer.services;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Chambre;
import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiant(Long EtudiantId);
    public Etudiant addEtudiant(Etudiant c);
    public void removeEtudiant(Long EtudiantId);
    public Etudiant modifyEtudiant(Etudiant Etudiant);
    public List<Etudiant> searchEtudiantbyEcoleAndDateNaissance(String ecole, Date datenaissance);
    public Chambre trouverChselonEt(Long cin);
}
