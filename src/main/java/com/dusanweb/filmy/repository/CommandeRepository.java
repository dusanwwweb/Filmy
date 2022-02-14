package com.dusanweb.filmy.repository;

import com.dusanweb.filmy.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    Commande findByIdCommande(int idCommande);
}
