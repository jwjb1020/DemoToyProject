package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.FindAllFestival;
// view에 있는 테이블 repository에 저장하기
public interface FindAllFestivalRepository extends JpaRepository <FindAllFestival,Integer>{
    //이름으로 모든 연관된 정보 찾기
    List<FindAllFestival> findByFestivalNameContaining(String festivalName);
   
}
