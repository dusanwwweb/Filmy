package com.dusanweb.filmy.repository;

import com.dusanweb.filmy.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    /*
        Derived Queries with Spring Data JPA
     */
    Client findByIdClient(int idClient);
    Optional<List<Client>> findBySexe(char sexe);
}
