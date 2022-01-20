package com.dusanweb.filmy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "catalogue")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Catalogue_ID", updatable = false, nullable = false)
    private int idCatalogue;

    @Column(name = "Annee")
    private LocalDate anneeCatalogue;

    @Column(name = "Type_de_catalogue")
    private String typeDeCatalogue;
}
