package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BuildingInfo;

public interface BuildingInfoRepository extends JpaRepository<BuildingInfo, Integer> {
    
}
