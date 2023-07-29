package com.example.demo.domain;

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
public class Address {
    @Id
    private int address_id;
    private String sido;
    private String sigungu;
    private String eupmyun;
    private String doro;
    private String sangse;
    private int zip_no;
    private Double latitude;
    private Double longitude;
    private float x;
    private float y;
}
