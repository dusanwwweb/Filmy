package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Commande;
import com.dusanweb.filmy.service.CommandeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    CommandeServiceImpl commandeService;

    @GetMapping(path = "/all")
    public List<Commande> getAllCommandes(){
        log.info("200");
        return commandeService.getAll();
    }

    @PostMapping(path = "/create")
    public Commande createOneCommande(@RequestBody Commande commande){
        log.info("201");
        return commandeService.createOne(commande);
    }

}
