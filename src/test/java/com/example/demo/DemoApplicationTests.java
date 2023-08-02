package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	

	

}
