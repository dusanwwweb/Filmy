package com.dusanweb.filmy.controller;

import com.dusanweb.filmy.model.Catalogue;
import com.dusanweb.filmy.service.CatalogueServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/create")
    public Catalogue createOneCatalogue(@RequestBody Catalogue catalogue){
        return catalogueService.createOne(catalogue);
    }

    //OK
    //http://localhost:8080/catalogue/update/7
    @PutMapping("/update/{id}")
    public ResponseEntity<Catalogue> updateCatalogue(
            @PathVariable(value = "id") int id, @RequestBody Catalogue catalogueDetails) {
        Catalogue catalogue = catalogueService.getById(id);

        catalogue.setAnneeCatalogue(catalogueDetails.getAnneeCatalogue());
        catalogue.setTypeDeCatalogue(catalogueDetails.getTypeDeCatalogue());

        final Catalogue updatedCatalogue = catalogueService.createOne(catalogue);
        return ResponseEntity.ok(updatedCatalogue);
    }

    //OK
    //http://localhost:8080/catalogue/6
    @DeleteMapping("/{id}")
    public void deleteOneCatalogue(@PathVariable(value = "id") int id) {
        log.info("200");
        catalogueService.deleteCatalogueById(id);
    }

    //OK
    //http://localhost:8080/catalogue/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Catalogue findCatalogueById(@PathVariable(value = "id") int id) {
        log.info("200");
        return catalogueService.getById(id);
    }
}
