package com.dusanweb.filmy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Ref", updatable = false, nullable = false)
    private int idCommande;

    @Column(name = "Date_commande")
    private LocalDate dateDeCommande;

    @Column(name = "Type_de_catalogue")
    private String typeDeCatalogue;

    @Column(name = "Quantite")
    private int quantite;

    @Column(name = "Prix")
    private double prix;

    @Column(name = "Total")
    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "Client_ID")
    private Client idClient;

    @Column(name = "Livraison_ID")
    private Livraison idLivraison;

}
