package tn.esprit.tpfoyer.services;
import tn.esprit.tpfoyer.entities.Foyer;
import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long FoyerId);
    public Foyer addFoyer(Foyer c);
    public void removeFoyer(Long FoyerId);
    public Foyer modifyFoyer(Foyer Foyer);
}
