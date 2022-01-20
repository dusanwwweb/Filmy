package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Client;
import com.dusanweb.filmy.repository.ClientRepository;
import com.dusanweb.filmy.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
}
