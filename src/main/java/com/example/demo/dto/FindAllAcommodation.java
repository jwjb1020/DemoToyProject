package com.example.demo.dto;

import org.hibernate.annotations.Immutable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Immutable
@Table(name="acommodationall")
public class FindAllAcommodation {
    @Id
    private int acommodationId;
    private String acommodationName;
    private int upstair;
    private int downstair;
    private int startstair;
    private int endstair;
    private String acoclass;
    private int hansil;
    private int yangsil;
    private String address;
    private Float latitude;
    private Float longitude;
    private String tel; 

    
}
