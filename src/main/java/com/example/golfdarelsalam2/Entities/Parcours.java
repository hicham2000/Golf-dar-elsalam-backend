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
public class Parcours implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nom;
    public int trous;
    public int distance;

}
