package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Acommodation;



public interface AcommodationRepository extends JpaRepository<Acommodation, Integer>{
    
}
