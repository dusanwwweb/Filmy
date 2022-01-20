package com.dusanweb.filmy.model;

import com.dusanweb.filmy.utils.Genre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Produit_ID", updatable = false, nullable = false)
    private int idProduit;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Annee_de_parution")
    private LocalDate anneeDeParution;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genre", columnDefinition = "enum('DRAME','ACTION','COMEDIE','SF','ROMANCE')")
    private Genre genre;

    @Column(name = "Image")
    private String image;

    @Column(name = "Qte_Stock")
    private int quantite;
}
