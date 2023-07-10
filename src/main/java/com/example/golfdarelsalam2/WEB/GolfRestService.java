package com.example.golfdarelsalam2.WEB;

import com.example.golfdarelsalam2.DAO.AdminReservationRepository;
import com.example.golfdarelsalam2.DAO.ReservationRepository;
import com.example.golfdarelsalam2.DAO.UtilisateurRepository;
import com.example.golfdarelsalam2.Entities.AdminReservation;
import com.example.golfdarelsalam2.Entities.Reservation;
import com.example.golfdarelsalam2.Entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;


@RestController
@CrossOrigin("*")
public class GolfRestService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private AdminReservationRepository adminReservationRepository;


    @RequestMapping(value = "/Reservations",method = RequestMethod.GET)
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }


@RequestMapping(value = "/utilisateurs",method = RequestMethod.GET)
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @RequestMapping(value = "/Reservations",method = RequestMethod.POST)
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationRepository.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }


    @RequestMapping(value = "/Reservations/{id}", method = RequestMethod.DELETE)
    public Boolean deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return true;
    }




    @RequestMapping(value = "/Reservations/{id}", method = RequestMethod.PUT)
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {

        updatedReservation.setId(id);
        return reservationRepository.save(updatedReservation);
    }

    List<Reservation> reservationsToDelete;

    @RequestMapping(value = "/AdminReservations",method = RequestMethod.POST)
    public ResponseEntity<AdminReservation> createAdminReservation(@RequestBody AdminReservation adminReservation) {
        AdminReservation createdReservation = adminReservationRepository.save(adminReservation);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse(adminReservation.getStartdate());
            endDate = dateFormat.parse(adminReservation.getEnddate());
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the parsing exception if needed
        }


        if (adminReservation.getParcour().equals("Rouge")){
            // Get the utilisateurs with reservationdate between startdate and enddate
             this.reservationsToDelete = reservationRepository.findBetweenReservationDates(startDate, endDate,1);

            // Delete the utilisateurs
            for (Reservation reservation : reservationsToDelete) {
                reservationRepository.delete(reservation);
            }

            // Get the utilisateurs with reservationdate between startdate and enddate
            this.reservationsToDelete = reservationRepository.findBetweenReservationDates(startDate, endDate,3);

            // Delete the utilisateurs
            for (Reservation reservation : reservationsToDelete) {
                reservationRepository.delete(reservation);
            }

        }

        else if (adminReservation.getParcour().equals("Bleu")){
            // Get the utilisateurs with reservationdate between startdate and enddate
            this.reservationsToDelete = reservationRepository.findBetweenReservationDates(startDate, endDate,2);

            // Delete the utilisateurs
            for (Reservation reservation : reservationsToDelete) {
                reservationRepository.delete(reservation);
            }

            // Get the utilisateurs with reservationdate between startdate and enddate
            this.reservationsToDelete = reservationRepository.findBetweenReservationDates(startDate, endDate,4);

            // Delete the utilisateurs
            for (Reservation reservation : reservationsToDelete) {
                reservationRepository.delete(reservation);
            }
        }

        else {
            // Get the utilisateurs with reservationdate between startdate and enddate
            this.reservationsToDelete = reservationRepository.findBetweenReservationDates(startDate, endDate,5);

            // Delete the utilisateurs
            for (Reservation reservation : reservationsToDelete) {
                reservationRepository.delete(reservation);
            }


        }


        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @RequestMapping(value = "/AdminReservations",method = RequestMethod.GET)
    public List<AdminReservation> getAdminReservations() {
        return adminReservationRepository.findAll();
    }

}
