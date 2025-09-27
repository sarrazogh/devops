package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.repositories.ReservationRepository;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ReservationService implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation retrieveReservation(Long ReservationId) {
        return reservationRepository.findById(ReservationId).get();
    }

    public Reservation addReservation(Reservation c) {
        return reservationRepository.save(c);
    }

    public void removeReservation(Long ReservationId) {
        reservationRepository.deleteById(ReservationId);
    }

    public Reservation modifyReservation(Reservation Reservation) {
        return reservationRepository.save(Reservation);
    }

    @Scheduled(fixedRate = 50000) // 50 000 ms = 50 secondes
    public void mettreAJourEtAfficherReservations() {
        // 1. Mettre à jour les réservations antérieures au 01/01/2024
        Date dateLimite = java.sql.Date.valueOf(LocalDate.of(2024, 1, 1));
        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getAnneeUniversitaire().after(dateLimite)) {
                reservation.setEstValide(false); // Exemple de mise à jour
                reservationRepository.save(reservation);
            }
            log.info("{} réservations antérieures au 01/01/2024 ont été mises à jour");
        }
    }
}
