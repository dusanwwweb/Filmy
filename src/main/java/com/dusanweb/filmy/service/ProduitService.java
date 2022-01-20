package com.dusanweb.filmy.service;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }
}
