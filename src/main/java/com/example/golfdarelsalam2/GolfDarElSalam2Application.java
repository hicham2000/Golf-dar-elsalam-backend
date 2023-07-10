package com.example.golfdarelsalam2;


import com.example.golfdarelsalam2.DAO.ParcoursRepository;
import com.example.golfdarelsalam2.DAO.ReservationRepository;
import com.example.golfdarelsalam2.DAO.UtilisateurRepository;
import com.example.golfdarelsalam2.Entities.Parcours;
import com.example.golfdarelsalam2.Entities.Reservation;
import com.example.golfdarelsalam2.Entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GolfDarElSalam2Application  implements CommandLineRunner{

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ParcoursRepository parcoursRepository;


    public static void main(String[] args) {

        SpringApplication.run(GolfDarElSalam2Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        this.utilisateurRepository.save(
                new Utilisateur(1L,"Hicham Taib","hichamtaib@gmail.com",null,"0600148141",null,null,0,0)
        );
        this.utilisateurRepository.save(
                new Utilisateur(2L,"Rachid Sefrioui","hichamtaib@gmail.com",null,"0600148141",null,null,0,0)
        );
        this.utilisateurRepository.save(
          new Utilisateur(3L,"Karim Bernoussi","hichamtaib@gmail.com",null,"0600148141",null,null,0,0)
        );
        this.utilisateurRepository.save(
                new Utilisateur(4L,"Ould Abbou Amin","hichamtaib@gmail.com",null,"0600148141",null,null,0,0)
        );this.utilisateurRepository.save(
                new Utilisateur(5L,"Hassan Hernoussi","hichamtaib@gmail.com",null,"0600148141",null,null,0,0)
        );


        this.parcoursRepository.save(
                new Parcours(1L,"Rouge",18,99)
        );this.parcoursRepository.save(
                new Parcours(2L,"Bleu",18,99)
        );this.parcoursRepository.save(
                new Parcours(3L,"Rouge",9,99)
        );this.parcoursRepository.save(
                new Parcours(4L,"Bleu",9,99)
        );this.parcoursRepository.save(
                new Parcours(5L,"Vert",9,99)
        );
    }
}
