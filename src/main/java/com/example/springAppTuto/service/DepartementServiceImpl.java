package com.example.springAppTuto.service;

import com.example.springAppTuto.entity.Departement;
import com.example.springAppTuto.error.NotFoundException;
import com.example.springAppTuto.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class DepartementServiceImpl implements DepatementService {
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public Departement fetchDepartementById(Long departementId) throws NotFoundException {
        try {
            return departementRepository.findById(departementId).get();
        }
        catch (NoSuchElementException ex){
            throw new NotFoundException(String.format("Depatement of id : %d not Found",departementId));
        }
    }

    @Override
    public Departement saveDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> fetchDepartementList() {
        return departementRepository.findAll();
    }

    @Override
    public void DeleteDepartementById(Long departementId) {
        departementRepository.deleteById(departementId);
    }

    @Override
    public Departement updateDepartement(Long departementId, Departement departement) {
        Departement dep =departementRepository.findById(departementId).get();

        if (Objects.nonNull(departement.getDepartementName()) && !"".equalsIgnoreCase(departement.getDepartementName())) {
            dep.setDepartementName(departement.getDepartementName());
        }
        if (Objects.nonNull(departement.getDepartementAdress()) && !"".equalsIgnoreCase(departement.getDepartementAdress())) {
            dep.setDepartementAdress(departement.getDepartementAdress());
        }
        if (Objects.nonNull(departement.getDepartementCode()) && !"".equalsIgnoreCase(departement.getDepartementCode())) {
            dep.setDepartementCode(departement.getDepartementCode());

        }
        return departementRepository.save(dep);
    }

    @Override
    public Departement fetchDepartementByname(String name) {
        return departementRepository.findByDepartementNameIgnoreCase(name);
    }

}
