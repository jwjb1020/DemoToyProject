package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.AcommodationInfo;



public interface AcommodationInfoRepository extends JpaRepository<AcommodationInfo,Integer>{
    
}
