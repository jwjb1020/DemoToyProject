package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.FindAllFestival;
import com.example.demo.repository.FindAllFestivalRepository;
import com.example.demo.service.AcommodationDataInputService;
import com.example.demo.service.FestivalDataInputService;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private FestivalDataInputService festivalDataInputService;
	@Autowired
	private AcommodationDataInputService acommodationDataInputService;
	@Test
	void contextLoads() {
		festivalDataInputService.ExcelFileRead();
		acommodationDataInputService.ExcelFileReadAcommodation();

	}
	// @Autowired
	// FindAllFestivalRepository repo;
	// @Test
	// public void Test(){
	//    List<FindAllFestival> a =repo.findAll();
	//    System.out.println("test : "+a.size());
	//    for(FindAllFestival f: a){
	// 	System.out.println(f);
	//    }
		
	}
	


