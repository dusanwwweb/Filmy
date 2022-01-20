package com.dusanweb.filmy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "livraison")
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Livraison_ID", updatable = false, nullable = false)
    private int idLivraison;

    @Column(name = "Type_de_livraison")
    private String typeDeLivraison;
}
