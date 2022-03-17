package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Client;
import com.dusanweb.filmy.service.ClientServiceImpl;
import com.dusanweb.filmy.utils.JacksonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientServiceImpl clientService;

    Client client1, client2, client2WithoutId;

    @BeforeEach
    public void setUp(){
        Client client1 = Client
                .builder()
                .idClient(1)
                .nom("Charlie")
                .prenom("Brown")
                .sexe('M')
                .adresse("114 rue Rivoli")
                .email("brownc@gmail.com")
                .motDePasse("pass")
                .build();

        Client client2 = Client
                .builder()
                .idClient(1)
                .nom("Snoopy")
                .prenom("Brown")
                .sexe('M')
                .adresse("114 rue Rivoli")
                .email("snoopy@gmail.com")
                .motDePasse("pass")
                .build();

        Client client2WithoutId = Client
                .builder()
                .nom("Snoopy")
                .prenom("Brown")
                .sexe('M')
                .adresse("114 rue Rivoli")
                .email("snoopy@gmail.com")
                .motDePasse("pass")
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("Should get all Clients")
    public void getAllClientsTest() throws Exception {

        //given
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        //when
        Mockito.when(clientService.getAll()).thenReturn(clients);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/client/all"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idClient", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nom", Matchers.is("Snoopy")))
                .andDo(print());
    }

    @Test
    @Order(2)
    @DisplayName("Should create new Client")
    public void createOneClientTest() throws Exception {
        doReturn(client2).when(clientService).createOne(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/client/create")
                .content(JacksonParser.asJsonString(client2WithoutId))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id", Matchers.is(1)));
    }

    @Test
    @Order(3)
    @DisplayName("Should find Client by ID")
    public void findClientByIdTest() throws Exception {
        doReturn(client1).when(clientService).getById(1);

        mockMvc.perform(MockMvcRequestBuilders.get("/client/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(jsonPath("$.id", Matchers.is(1)));
    }

}