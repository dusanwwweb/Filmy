package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Client;
import com.dusanweb.filmy.service.ClientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientControllerTestJunit {

    @Mock
    ClientServiceImpl clientService;

    @Mock
    Logger log;

    @InjectMocks
    ClientController clientController;

    /*
    //DEPRECATED
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

     */


    @Test
    void testGetAllClients() {
        when(clientService.getAll()).thenReturn(Arrays.<Client>asList(new Client()));

        List<Client> result = clientController.getAllClients();
        Assertions.assertEquals(Arrays.<Client>asList(new Client()), result);
    }

    @Test
    void testCreateOneClient() {
        when(clientService.createOne(any())).thenReturn(new Client());

        Client result = clientController.createOneClient(new Client());
        Assertions.assertEquals(new Client(), result);
    }

    @Test
    void testUpdateClient() {
        when(clientService.createOne(any())).thenReturn(new Client());
        when(clientService.getById(anyInt())).thenReturn(new Client());

        ResponseEntity<Client> result = clientController.updateClient(0, new Client());
        Assertions.assertEquals(null, result);
    }

    @Test
    void testDeleteOneClient() {
        clientController.deleteOneClient(0);
    }

    @Test
    void testDeleteClient() {
        ResponseEntity<Void> result = clientController.deleteClient(0);
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindClientById() {
        when(clientService.getById(anyInt())).thenReturn(new Client());

        Client result = clientController.findClientById(0);
        Assertions.assertEquals(new Client(), result);
    }

    @Test
    void testGetClientByid() {
        when(clientService.getById(anyInt())).thenReturn(new Client());

        Client result = clientController.getClientByid(0);
        Assertions.assertEquals(new Client(), result);
    }

    @Test
    void testGetClientBySex() {
        when(clientService.getBySex(anyChar())).thenReturn(null);

        Optional<List<Client>> result = clientController.getClientBySex('M');
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindClientBySex() {
        when(clientService.getBySex(anyChar())).thenReturn(null);

        ResponseEntity<List<Client>> result = clientController.findClientBySex('F');
        Assertions.assertEquals(null, result);
    }
}