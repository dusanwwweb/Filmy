package com.dusanweb.filmy.service;

import com.dusanweb.filmy.model.Client;
import com.dusanweb.filmy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements FilmyService<Client>{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client createOne(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClientById(int id) {
        clientRepository.deleteById(id);
    }

    public Client getById(int idClient) {
        return clientRepository.findByIdClient(idClient);
    }

    public Optional<List<Client>> getBySex(char sexe) {
        return clientRepository.findBySexe(sexe);
    }

}
