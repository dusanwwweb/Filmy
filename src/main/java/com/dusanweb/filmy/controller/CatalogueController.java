package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Catalogue;
import com.dusanweb.filmy.service.CatalogueServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    CatalogueServiceImpl catalogueService;

    @GetMapping(path = "/all")
    public List<Catalogue> getAllCatalogues(){
        return catalogueService.getAll();
    }
}
