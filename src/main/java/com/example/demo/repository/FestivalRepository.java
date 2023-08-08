package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Integer> {
    // 추가적인 커스텀 쿼리 메서드 등을 선언할 수 있습니다.
    // @Query("SELECT f.festivalName FROM Festival f WHERE f.festivalName LIKE %?1%")
    // List<Festival> findByFestivalName(String festivalName);
    List<Festival> findByFestivalNameContaining(String festivalName);
}
