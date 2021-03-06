package com.dusanweb.filmy.repository;

import com.dusanweb.filmy.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
    Produit findByIdProduit(int id);
}
