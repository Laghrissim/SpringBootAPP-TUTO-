package com.example.springAppTuto.service;

import com.example.springAppTuto.entity.Departement;
import com.example.springAppTuto.repository.DepartementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
@SpringBootTest
class DepatementServiceTest {


    @MockBean
    private DepartementRepository departementRepository;
    @Autowired
    DepatementService depatementService;

    @BeforeEach
    void setUp() {
       Departement departement= Departement.builder()
               .departementName("IT")
               .departementAdress("Rabat")
               .departementCode("IT-01-RM")
               .depatementId(1L)
               .build();
        Mockito.when(departementRepository.findByDepartementNameIgnoreCase("IT")).thenReturn(departement);

    }


    @Test
    @DisplayName("Get Department By Valid DepartementName" )
    public void whenValidDepartementName_ThenShouldBeFound(){
        String departementName = "IT";
        Departement found = depatementService.fetchDepartementByname(departementName);
        assertEquals(departementName,found.getDepartementName());
    }
}