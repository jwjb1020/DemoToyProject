package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Info;



public interface InfoRepository extends JpaRepository<Info, Integer> {
    
}
