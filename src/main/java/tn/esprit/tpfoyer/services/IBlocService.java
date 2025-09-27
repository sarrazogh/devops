package tn.esprit.tpfoyer.services;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long BlocId);
    public Bloc addBloc(Bloc c);
    public void removeBloc(Long BlocId);
    public Bloc modifyBloc(Bloc Bloc);

}
