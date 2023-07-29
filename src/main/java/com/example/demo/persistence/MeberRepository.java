package com.example.demo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Member;

public interface MeberRepository extends JpaRepository<Member, String> {
    
}
