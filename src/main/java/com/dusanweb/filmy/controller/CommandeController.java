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
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    CommandeServiceImpl commandeService;

    //http://localhost:8080/commande/all
    @GetMapping(path = "/all")
    public List<Commande> getAllCommandes(){
        log.info("200");
        return commandeService.getAll();
    }

    //http://localhost:8080/commande/create
    @PostMapping(path = "/create")
    public Commande createOneCommande(@RequestBody Commande commande){
        log.info("201");
        return commandeService.createOne(commande);
    }
    //http://localhost:8080/commande/update/1
    @PutMapping("/update/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") int id, @RequestBody Commande commandeDetails) {
        Commande commande = commandeService.getById(id);

        commande.setDateDeCommande(commandeDetails.getDateDeCommande());
        commande.setQuantite(commandeDetails.getQuantite());
        commande.setPrix(commandeDetails.getPrix());
        commande.setTotal(commandeDetails.getTotal());

        final Commande updatedCommande = commandeService.createOne(commande);
        return ResponseEntity.ok(updatedCommande);
    }

    //http://localhost:8080/commande/5
    @DeleteMapping("/{id}")
    public void deleteOneCommande(@PathVariable(value = "id") int id) {
        log.info("200");
        commandeService.deleteCommandeById(id);
    }

    //http://localhost:8080/commande/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Commande findCommandeById(@PathVariable(value = "id") int id) {
        log.info("200");
        return commandeService.getById(id);
    }
}
