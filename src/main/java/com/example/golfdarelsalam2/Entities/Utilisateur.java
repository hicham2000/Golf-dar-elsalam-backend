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

public class Utilisateur implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long licence;
    public String nom;
    public String email;
    public String second_email;
    public String telephone_fix;
    public String telephone_mobile;
    public String password;
    public double user_index;
    public int is_admin = 0;

}
