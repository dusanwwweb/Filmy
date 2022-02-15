package com.dusanweb.filmy.service;

import java.util.List;

public interface FilmyService<T> {

    List<T> getAll();

    T createOne(T t);

//    void deleteOne(T t);

//    T updateOne();

}
