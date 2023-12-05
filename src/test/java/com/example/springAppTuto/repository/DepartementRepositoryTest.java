package com.example.springAppTuto.repository;

import com.example.springAppTuto.entity.Departement;
import jakarta.persistence.EntityManager;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartementRepositoryTest {

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Departement departement = Departement.builder()
                .departementName("Computer Engineering")
                .departementCode("CE-98")
                .departementAdress("RABAT")
                .build();
        entityManager.persist(departement);
    }
    @Test
    public void whenFindById_thenReturnDepartement(){
    Departement departement =departementRepository.findById(1L).get();
    assertEquals(departement.getDepartementName(),"Computer Engineering");

    }
}