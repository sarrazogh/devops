package tn.esprit.tpfoyer.services;
import tn.esprit.tpfoyer.entities.Reservation;
import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long ReservationId);
    public Reservation addReservation(Reservation c);
    public void removeReservation(Long ReservationId);
    public Reservation modifyReservation(Reservation Reservation);
}
