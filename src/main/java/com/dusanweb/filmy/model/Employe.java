package com.dusanweb.filmy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employe_ID", updatable = false, nullable = false)
    private int idEmploye;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Statut")
    private String statut;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mot_de_passe")
    private String motDePasse;
}
