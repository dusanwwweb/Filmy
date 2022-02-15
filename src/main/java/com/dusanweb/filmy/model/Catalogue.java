package com.dusanweb.filmy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "catalogue")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogue_id", updatable = false, nullable = false)
    private int idCatalogue;

    @Column(name = "annee")
    private LocalDate anneeCatalogue;

    @Column(name = "type_de_catalogue")
    private String typeDeCatalogue;

    /*
        JPA RELATIONSHIPS
    */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "catalogue_produit",
            joinColumns = @JoinColumn(name = "catalogue_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private Set<Produit> produitSet = new HashSet<>();


    public void assignProduit(Produit produit) {
        produitSet.add(produit);
    }
}
