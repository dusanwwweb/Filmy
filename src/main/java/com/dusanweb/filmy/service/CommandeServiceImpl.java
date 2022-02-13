package com.dusanweb.filmy.service;

import com.dusanweb.filmy.model.Commande;
import com.dusanweb.filmy.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements FilmyService<Commande>{

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande createOne(Commande commande) {
        return commandeRepository.save(commande);
    }

//    @Override
//    public void deleteOne(Commande commande) {
//        commandeRepository.delete(commande);
//    }
}
