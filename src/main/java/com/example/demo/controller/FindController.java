package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FindAllAcommodation;
import com.example.demo.dto.FindAllFestival;
import com.example.demo.entity.Festival;
import com.example.demo.service.FindService;

@RestController
@RequestMapping("/search")
public class FindController {

    @Autowired
    FindService findService;
    
    @GetMapping("/find")
    public List<Festival> findFestival(@RequestParam("festivalName") String festivalName){
        
        return findService.find(festivalName);  
    }
    @GetMapping("/findall")
    public List<FindAllFestival> findAllFestival(@RequestParam("festivalName") String festivalName){
        
        return findService.findAll(festivalName);  
    }
    @GetMapping("/findAcommodation")
    public List<FindAllAcommodation> findAllAcommodations(@RequestParam("address") String address){
        return findService.findAllAcommodations(address);
    }



}

