package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member;

public interface MeberRepository extends JpaRepository<Member, String> {
    
}
