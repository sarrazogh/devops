package tn.esprit.tpfoyer.services;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public List<Chambre> searchChambrepartype(TypeChambre chambre);
    public Chambre searchChambreparnumerochambre(Long numch);
    public Chambre addProjetAndProjetDetailAndAssign(Chambre ch);
}
