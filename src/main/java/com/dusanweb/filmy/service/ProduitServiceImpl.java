package com.dusanweb.filmy.service;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements FilmyService<Produit> {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit createOne(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getById(int id) {
        return produitRepository.findByIdProduit(id);
    }

    public void deleteProduitById(int id) {
        produitRepository.deleteById(id);
    }

}
