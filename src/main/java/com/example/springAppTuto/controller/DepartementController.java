package com.example.springAppTuto.controller;

import com.example.springAppTuto.entity.Departement;
import com.example.springAppTuto.error.NotFoundException;
import com.example.springAppTuto.service.DepatementService;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementController {
    @Autowired
    private DepatementService depatementService;
    private final Logger LOGGER =LoggerFactory.getLogger(Departement.class);
    @PostMapping(value = "/departement")
    public Departement saveDepartement(@Valid @RequestBody Departement departement) {
        return depatementService.saveDepartement(departement);
    }
    @GetMapping(value = "/departement")
    public List<Departement> fetchDepartementList(){
        return depatementService.fetchDepartementList();
    }

    @GetMapping("/departement/{id}")
    public Departement fetchDepartementById(@PathVariable("id") Long departementId) throws NotFoundException {
        return depatementService.fetchDepartementById(departementId);
    }

    @DeleteMapping("/departement/{id}")
    public String DeleteDepartementById(@PathVariable("id") Long departementId){
        depatementService.DeleteDepartementById(departementId);
        return "Departement Deleted Succesfully";
    }

    @PutMapping("/departement/{id}")
    public Departement updateDepartement(@PathVariable("id") Long departementId,@RequestBody Departement departement){
        return depatementService.updateDepartement(departementId,departement);
    }

    @GetMapping("/departement/name/{name}")
    public Departement fetchDepartementByName(@PathVariable String name){
        return depatementService.fetchDepartementByname(name);
    }
}
