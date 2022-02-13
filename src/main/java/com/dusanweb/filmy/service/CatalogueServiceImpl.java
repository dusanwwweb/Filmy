package com.dusanweb.filmy.service;

import com.dusanweb.filmy.model.Catalogue;
import com.dusanweb.filmy.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueServiceImpl implements FilmyService<Catalogue> {

    @Autowired
    CatalogueRepository catalogueRepository;

    @Override
    public List<Catalogue> getAll() {
        return catalogueRepository.findAll();
    }

    @Override
    public Catalogue createOne(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }

    public Catalogue getById(int id) {
        return catalogueRepository.findByIdCatalogue(id);
    }

    public void deleteCatalogueById(int id) {
        catalogueRepository.deleteById(id);
    }

}
