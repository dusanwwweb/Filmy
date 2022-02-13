package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Client;
import com.dusanweb.filmy.service.ClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    //OK
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients(){
        log.info("200");
        return clientService.getAll();
    }

    //OK
    @PostMapping("/create")
    public Client createOneClient(@RequestBody Client client) {
        log.info("201");
        return clientService.createOne(client);
    }

    //OK
    //http://localhost:8080/client/update/7
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable(value = "id") int id, @RequestBody Client clientDetails) {
        Client client = clientService.getById(id);

        client.setNom(clientDetails.getNom());
        client.setPrenom(clientDetails.getPrenom());
        client.setSexe(clientDetails.getSexe());
        client.setAdresse(clientDetails.getAdresse());
        client.setEmail(clientDetails.getEmail());
        client.setMotDePasse(clientDetails.getMotDePasse());

        final Client updatedClient = clientService.createOne(client);
        return ResponseEntity.ok(updatedClient);
    }

    //OK
    //http://localhost:8080/client/6
    @DeleteMapping("/{id}")
    public void deleteOneClient(@PathVariable(value = "id") int id) {
        log.info("200");
        clientService.deleteClientById(id);
    }

    //http://localhost:8080/client/id?id=6
    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteClient(@RequestParam(value = "id") int id) {
        try {
            clientService.deleteClientById(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    //OK
    //http://localhost:8080/client/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findClientById(@PathVariable(value = "id") int id) {
        log.info("200");
        return clientService.getById(id);

    }

    //OK
    //http://localhost:8080/client/id?id=1
    @GetMapping("id")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientByid(@RequestParam(value = "id") int id){
        log.info("200");
        return clientService.getById(id);
    }

    //OK
    //http://localhost:8080/client/sex?sex=f
    @GetMapping("/sex")
    @ResponseStatus(HttpStatus.OK)
    public Optional<List<Client>> getClientBySex(@RequestParam(value = "sex") char sexe){
        log.info("200");
        return clientService.getBySex(sexe);
    }

    //OK
    //http://localhost:8080/client/sex/f
    @GetMapping("sex/{sex}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Client>> findClientBySex(@PathVariable(value = "sex") char sexe) {
        Optional<List<Client>> clients = clientService.getBySex(sexe);;
        log.info("200");
        return clients.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
