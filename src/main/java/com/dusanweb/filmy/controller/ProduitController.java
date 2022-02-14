package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.service.ProduitServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //OK
    //http://localhost:8080/produit/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<Produit> updateProduit(
            @PathVariable(value = "id") int id, @RequestBody Produit produitDetails) {
        Produit produit = produitService.getById(id);

        produit.setNom(produitDetails.getNom());
        produit.setAnneeDeParution(produitDetails.getAnneeDeParution());
        produit.setGenre(produitDetails.getGenre());
        produit.setImage(produitDetails.getImage());
        produit.setQuantite(produitDetails.getQuantite());

        final Produit updatedProduit = produitService.createOne(produit);
        return ResponseEntity.ok(updatedProduit);
    }

    //OK
    //http://localhost:8080/produit/31
    @DeleteMapping("/{id}")
    public void deleteOneProduit(@PathVariable(value = "id") int id) {
        log.info("200");
        produitService.deleteProduitById(id);
    }

    //OK
    //http://localhost:8080/produit/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produit findProduitById(@PathVariable(value = "id") int id) {
        log.info("200");
        return produitService.getById(id);
    }
}
