package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Info;



public interface InfoRepository extends JpaRepository<Info, Integer> {
    
}
