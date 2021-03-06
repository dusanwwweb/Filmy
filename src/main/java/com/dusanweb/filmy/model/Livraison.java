package com.dusanweb.filmy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "livraison")
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livraison_id", updatable = false, nullable = false)
    private int idLivraison;

    @Column(name = "type_de_livraison")
    private String typeDeLivraison;

    /*
        JPA RELATIONSHIPS
    */
    @JsonIgnore
    @OneToMany(mappedBy = "livraison")
    private Set<Commande> commandes = new HashSet<>();
}
