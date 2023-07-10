package com.example.golfdarelsalam2.DAO;

import com.example.golfdarelsalam2.Entities.Reservation;
import com.example.golfdarelsalam2.Entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT u FROM Reservation u WHERE u.parcours = ?3 and STR_TO_DATE(u.date, '%d %b %Y') BETWEEN ?1 AND ?2")
    List<Reservation> findBetweenReservationDates(Date startDate, Date endDate,int parcour);

}