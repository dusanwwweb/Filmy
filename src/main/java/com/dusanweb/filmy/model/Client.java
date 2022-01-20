package com.dusanweb.filmy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    //Every JPA entity is required to have a field which maps to primary key of the database table.
    // Such field must be annotated with @Id.

    @GeneratedValue(strategy = GenerationType.AUTO)
    //The use of the GeneratedValue annotation is only required for simple primary keys.
    //A simple primary key consists of a single Java field which maps to a single table column.

    //GenerationType.AUTO - This GenerationType indicates that the persistence provider should
    // automatically pick an appropriate strategy for the particular database.
    // This is the default GenerationType, i.e. if we just use @GeneratedValue
    // annotation then this value of GenerationType will be used.
    @Column(name = "Client_ID", updatable = false, nullable = false)
    private int idClient;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Sexe")
    private char sexe;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Email")
    private String email;

    @Column(name = "Mot_de_passe")
    private String motDePasse;
}
