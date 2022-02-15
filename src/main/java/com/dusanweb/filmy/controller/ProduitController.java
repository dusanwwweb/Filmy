package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Commande;
import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.service.CommandeServiceImpl;
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

    @Autowired
    CommandeServiceImpl commandeService;

    //http://localhost:8080/produit/all
    @GetMapping(path = "/all")
    public List<Produit> getAllProduits(){
        log.info("200");
        return produitService.getAll();
    }

    //http://localhost:8080/produit/create
    @PostMapping(path = "/create")
    public Produit createOneProduit(@RequestBody Produit produit){
        log.info("201");
        return produitService.createOne(produit);
    }

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

    //http://localhost:8080/produit/31
    @DeleteMapping("/{id}")
    public void deleteOneProduit(@PathVariable(value = "id") int id) {
        log.info("200");
        produitService.deleteProduitById(id);
    }

    //http://localhost:8080/produit/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produit findProduitById(@PathVariable(value = "id") int id) {
        log.info("200");
        return produitService.getById(id);
    }

    //http://localhost:8080/produit/31/commande/5
    @PutMapping("/{produitId}/commande/{commandeId}")
    public ResponseEntity<Produit> updateCatalogueProduit(
            @PathVariable(value = "produitId") int prodId,
            @PathVariable(value = "commandeId") int commId
            ) {

        Produit produit = produitService.getById(prodId);
        Commande commande = commandeService.getById(commId);

        produit.assignCommande(commande);

        final Produit updatedProduit  = produitService.createOne(produit);
        return ResponseEntity.ok(updatedProduit);
    }
}
