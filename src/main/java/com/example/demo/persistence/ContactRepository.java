package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    
}
