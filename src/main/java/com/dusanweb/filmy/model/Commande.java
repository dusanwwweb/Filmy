package com.dusanweb.filmy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commande_id", updatable = false, nullable = false)
    private int idCommande;

    @Column(name = "date_commande")
    private LocalDate dateDeCommande;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "prix")
    private double prix;

    @Column(name = "total")
    private double total;

    /*
        JPA RELATIONSHIPS
     */

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "livraison_id")
    private Livraison livraison;

    @JsonIgnore
    @ManyToMany(mappedBy = "commandeSet")
    private Set<Produit> produitSet = new HashSet<>();
}
