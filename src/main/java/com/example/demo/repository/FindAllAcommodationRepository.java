package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.FindAllAcommodation;

public interface FindAllAcommodationRepository extends JpaRepository<FindAllAcommodation, Integer>{
    //주소에 있는 주소명으로 찾기
    List<FindAllAcommodation> findByAddressContaining(String address);
}
