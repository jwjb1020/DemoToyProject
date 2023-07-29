package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Acommodation;



public interface AcommodationRepository extends JpaRepository<Acommodation, Integer>{
    
}
