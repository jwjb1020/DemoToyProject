package com.example.demo.entity;


import com.example.demo.dto.FindDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int festival_id;
    private int contact_id;
    private int address_id;
    @Column(name = "festival_name")
    private String festivalName;
    private int info_id;


    public Festival(String festivalName) {
      
        this.festivalName = festivalName;
        
       
    }
   
    
}
