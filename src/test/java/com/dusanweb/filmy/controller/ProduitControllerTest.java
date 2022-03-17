package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.service.CommandeServiceImpl;
import com.dusanweb.filmy.service.ProduitServiceImpl;
import com.dusanweb.filmy.utils.Genre;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ProduitController.class)
public class ProduitControllerTest {

    @MockBean
    private ProduitServiceImpl produitService;

    @MockBean
    private CommandeServiceImpl commandeService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    Produit produit1, produit2, produit2WithoutId;

    @BeforeEach
    public void setUp(){
        produit1 = Produit
                .builder()
                .idProduit(1)
                .nom("SNOOPY")
                .anneeDeParution(LocalDate.ofEpochDay(1982-02-15))
                .genre(Genre.SF)
                .image("http://www.covermax.net/uploads/extgallery/public-photo/medium/the_swordsman_cf3ea.jpg")
                .quantite(1)
                .build();

        produit2 = Produit
                .builder()
                .idProduit(2)
                .nom("BATMAN")
                .anneeDeParution(LocalDate.ofEpochDay(2020-11-12))
                .genre(Genre.SF)
                .image("http://www.covermax.net/uploads/extgallery/public-photo/medium/the_swordsman_cf3ea.jpg")
                .quantite(5)
                .build();

        produit2WithoutId = Produit
                .builder()
                .nom("BATMAN")
                .anneeDeParution(LocalDate.ofEpochDay(2020-11-12))
                .genre(Genre.SF)
                .image("http://www.covermax.net/uploads/extgallery/public-photo/medium/the_swordsman_cf3ea.jpg")
                .quantite(5)
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("GET request to endpoint - /produit/all")
    public void testGetAllProduits() throws Exception {

        //given
        List<Produit> produits = new ArrayList<>();
        produits.add(produit1);
        produits.add(produit2);

        //when
        Mockito.when(produitService.getAll()).thenReturn(produits);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/produit/all"))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idProduit", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nom", Matchers.is("BATMAN")));
    }

    @Test
    @Order(2)
    @DisplayName("POST request to endpoint - /produit/create")
    public void createOneProduit() throws Exception {
        // com.fasterxml.jackson.datatype:jackson-datatype-jsr310
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        //when
        Mockito.when(produitService.createOne(produit2WithoutId)).thenReturn(produit2);

        mockMvc.perform( MockMvcRequestBuilders.post("/produit/create")
                .content(JacksonParser.asJsonString(produit2WithoutId))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idProduit").exists());
    }

}