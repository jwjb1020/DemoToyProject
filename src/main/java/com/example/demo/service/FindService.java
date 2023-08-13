package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FindAllAcommodation;
import com.example.demo.dto.FindAllFestival;
import com.example.demo.entity.Festival;
import com.example.demo.repository.FestivalRepository;
import com.example.demo.repository.FindAllAcommodationRepository;
import com.example.demo.repository.FindAllFestivalRepository;

@Service
public class FindService {

    @Autowired
    FestivalRepository festivalRepository;
    @Autowired
    FindAllFestivalRepository repo;
    @Autowired
    FindAllAcommodationRepository repo2;

    // public Object find(Festival festivalName){
    // // String findLocation =dto.getFindLocation();
    // // String findAcommodation = dto.getFindAcommodation();
    // // String findFestival = dto.getFindFestival();
    // List<String> festivalNameList =
    // festivalRepository.findByFestivalName(festivalName.getFestivalName());
    // return festivalNameList;
    // };
    public List<Festival> find(String festivalName) {
        return festivalRepository.findByFestivalNameContaining(festivalName);
    }

    public List<FindAllFestival> findAll(String festivalName) {
        return repo.findByFestivalNameContaining(festivalName);
    }

    public List<FindAllAcommodation> findAllAcommodations(String address){
        return repo2.findByAddressContaining(address);
    }
}
