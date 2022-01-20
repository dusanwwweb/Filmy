package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.service.ProduitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @GetMapping(path = "/all")
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
}
