package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Produit;
import com.dusanweb.filmy.service.FilmyService;
import com.dusanweb.filmy.service.ProduitServiceImpl;
import com.dusanweb.filmy.utils.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = ProduitController.class)
public class ProduitControllerTest {

    @MockBean
    private ProduitServiceImpl produitService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should get all the products when making GET request to endpoint - /produit/all")
    public void shouldGetetAllProduits() throws Exception {

        Produit produit1 = new Produit()
                .builder()
                .idProduit(1)
                .nom("SNOOPY")
                .anneeDeParution(LocalDate.ofEpochDay(1982-02-15))
                .genre(Genre.SF)
                .image("http://www.covermax.net/uploads/extgallery/public-photo/medium/the_swordsman_cf3ea.jpg")
                .quantite(1)
                .build();


        mockMvc.perform(MockMvcRequestBuilders.get("/produit/all"))
                .andExpect(MockMvcResultMatchers.status().is(200))

    }
}