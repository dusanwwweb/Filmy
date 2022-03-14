package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Client;
import com.dusanweb.filmy.service.ClientServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

//@Listeners(MockitoTestNGListener.class)
public class ClientControllerTest {

    @Mock
    ClientServiceImpl clientService;

    @Mock
    Logger log;

    @InjectMocks
    ClientController clientController;


    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test(testName = "GetAllClients")
    public void testGetAllClients() {
        when(clientService.getAll()).thenReturn(Arrays.<Client>asList(new Client()));

        List<Client> result = clientController.getAllClients();
        Assert.assertEquals(result, Arrays.<Client>asList(new Client()));
    }

    @Test
    public void testCreateOneClient() {
        when(clientService.createOne(any())).thenReturn(new Client());

        Client result = clientController.createOneClient(new Client());
        Assert.assertEquals(result, new Client());
    }

    @Test
    public void testUpdateClient() {
        when(clientService.createOne(any())).thenReturn(new Client());
        when(clientService.getById(anyInt())).thenReturn(new Client());

        ResponseEntity<Client> result = clientController.updateClient(0, new Client());
        Assert.assertEquals(result, null);
    }

    @Test
    public void testDeleteOneClient() {
        clientController.deleteOneClient(0);
    }

    @Test
    public void testDeleteClient() {
        ResponseEntity<Void> result = clientController.deleteClient(0);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testFindClientById() {
        when(clientService.getById(anyInt())).thenReturn(new Client());

        Client result = clientController.findClientById(0);
        Assert.assertEquals(result, new Client());
    }

    @Test
    public void testGetClientByid() {
        when(clientService.getById(anyInt())).thenReturn(new Client());

        Client result = clientController.getClientByid(0);
        Assert.assertEquals(result, new Client());
    }

    @Test
    public void testGetClientBySex() {
        when(clientService.getBySex(anyChar())).thenReturn(null);

        Optional<List<Client>> result = clientController.getClientBySex('a');
        Assert.assertEquals(result, null);
    }

    @Test
    public void testFindClientBySex() {
        when(clientService.getBySex(anyChar())).thenReturn(null);

        ResponseEntity<List<Client>> result = clientController.findClientBySex('a');
        Assert.assertEquals(result, null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme