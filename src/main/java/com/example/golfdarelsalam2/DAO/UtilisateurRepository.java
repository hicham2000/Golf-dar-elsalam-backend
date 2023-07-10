package com.example.golfdarelsalam2.DAO;

import com.example.golfdarelsalam2.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}
