package com.dusanweb.filmy.model;

import com.dusanweb.filmy.utils.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id", updatable = false, nullable = false)
    private int idProduit;

    @Column(name = "nom")
    private String nom;

    @Column(name = "annee_de_parution")
    private LocalDate anneeDeParution;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", columnDefinition = "enum('DRAME','ACTION','COMEDIE','SF','ROMANCE')")
    private Genre genre;

    @Column(name = "image")
    private String image;

    @Column(name = "qte_stock")
    private int quantite;

    /*
        JPA RELATIONSHIPS
    */
    @JsonIgnore
    @ManyToMany(mappedBy = "produitSet")
    private Set<Catalogue> catalogueSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "commande_produit",
            joinColumns = @JoinColumn(name = "produit_id"),
            inverseJoinColumns = @JoinColumn(name = "commande_id"))
    private Set<Commande> commandeSet = new HashSet<>();
}
