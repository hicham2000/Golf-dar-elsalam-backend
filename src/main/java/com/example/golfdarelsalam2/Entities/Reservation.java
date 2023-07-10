package com.example.golfdarelsalam2.Entities;


import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public int User_licence;
    public String date;
    public String heure;
    public int parcours;
    public int caddie;
    public int vehicule;
    public int partenaire_1;
    public int partenaire_2;
    public int partenaire_3;
    public int active = 1;
}
