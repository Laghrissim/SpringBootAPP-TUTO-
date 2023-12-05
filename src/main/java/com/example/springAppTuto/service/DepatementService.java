package com.example.springAppTuto.service;

import com.example.springAppTuto.entity.Departement;
import com.example.springAppTuto.error.NotFoundException;

import java.util.List;

public interface DepatementService {
    Departement fetchDepartementById(Long departementId) throws NotFoundException;

    Departement saveDepartement(Departement departement);

    List<Departement> fetchDepartementList();

    void DeleteDepartementById(Long departementId);


    Departement updateDepartement(Long departementId, Departement departement);

    Departement fetchDepartementByname(String name);
}
