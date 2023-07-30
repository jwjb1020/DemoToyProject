package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
    @Id
   
    private int contact_id;
    @Column(length = 1024)
    private String homepage;
    private String tel;
    private String jugwan;
    

    
}
