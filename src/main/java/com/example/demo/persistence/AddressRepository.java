package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
