package tn.esprit.tpfoyer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.services.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    IReservationService reservationService;

    // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    // http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long resId) {
        Reservation reservation = reservationService.retrieveReservation(resId);
        return reservation;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }

    // http://localhost:8089/tpfoyer/reservation/remove-reservation/{reservation-id}
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long resId) {
        reservationService.removeReservation(resId);
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.modifyReservation(r);
        return reservation;
    }
}
