package com.example.springAppTuto.repository;

import com.example.springAppTuto.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
    Departement findByDepartementNameIgnoreCase(String name);
}
