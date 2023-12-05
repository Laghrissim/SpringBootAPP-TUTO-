package com.example.springAppTuto.controller;

import com.example.springAppTuto.entity.Departement;
import com.example.springAppTuto.error.NotFoundException;
import com.example.springAppTuto.service.DepartementServiceImpl;
import com.example.springAppTuto.service.DepatementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartementController.class)
class DepartementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepatementService departementService;
    private Departement departement;
    @BeforeEach
    void setUp() {
        departement = Departement.builder()
                .departementName("Computer Engineering")
                .departementCode("CE-98")
                .departementAdress("RABAT")
                .build();
    }

    @Test
    @DisplayName("test saveDepartemnt post:/departement")
    void saveDepartement() throws Exception {
        Departement inputDepartement = Departement.builder()
                .departementName("Computer Engineering")
                .departementCode("CE-98")
                .departementAdress("RABAT")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        Mockito.when(departementService.saveDepartement(inputDepartement)).thenReturn(departement);

        mockMvc.perform(post("/departement").contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(inputDepartement))
        ).andExpect(status().isOk());

    }

    @Test
    void fetchDepartementById() throws Exception {
        Mockito.when(departementService.fetchDepartementById(1L)).thenReturn(departement);
        mockMvc.perform(get("/departement/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departementName").value(departement.getDepartementName()));


    }
}