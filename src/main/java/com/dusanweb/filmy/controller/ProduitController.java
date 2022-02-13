package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.service.ProduitServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    ProduitServiceImpl produitService;

    @GetMapping(path = "/all")
    public List<Produit> getAllProduits(){
        log.info("200");
        return produitService.getAll();
    }

    @PostMapping(path = "/create")
    public Produit createOneProduit(@RequestBody Produit produit){
        log.info("201");
        return produitService.createOne(produit);
    }
}
