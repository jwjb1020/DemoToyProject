package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Festival;
import com.example.demo.repository.FestivalRepository;

@Service    
public class FindService {

    @Autowired
    FestivalRepository festivalRepository;

    // public Object find(Festival festivalName){
    //     // String findLocation =dto.getFindLocation();
    //     // String findAcommodation = dto.getFindAcommodation();
    //     // String findFestival = dto.getFindFestival();
    //     List<String> festivalNameList = festivalRepository.findByFestivalName(festivalName.getFestivalName());
    //     return festivalNameList;
    // };
    public List<Festival> find(String festivalName) {
        return festivalRepository.findByFestivalNameContaining(festivalName);
    } 
    }


   