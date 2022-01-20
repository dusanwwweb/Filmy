package com.dusanweb.filmy.service;

import com.dusanweb.filmy.model.Catalogue;

import java.util.List;

public interface FilmyService<T> {
    public List<T> getAll();
}
