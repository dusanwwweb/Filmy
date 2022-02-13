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

//    @Override
//    public void deleteOne(Produit produit) {
//        produitRepository.delete(produit);
//    }
}
