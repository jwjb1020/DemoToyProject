package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.SelectFestival;

public interface SelectFestivalRepo extends JpaRepository<SelectFestival,String>{
    
}
