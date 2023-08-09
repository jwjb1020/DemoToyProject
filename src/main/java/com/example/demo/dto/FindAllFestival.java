package com.example.demo.dto;

import java.util.Date;

import org.hibernate.annotations.Immutable;

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
//table명도 정확하게 적어야함! 대소문자 구분해서
@Table(name="findallfestival")
//새롭게 database view에 join한 테이블 만들어서 새로운 엔티티 만들기
public class FindAllFestival {
    @Id
    private int festivalId;
    private String festivalName;
    private String place;
    private Date start;
    private Date end;
    private String content;
    private String contentInfo;
    private String address;
    private String zipNo;
    private String tel;
    private String homepage;
    private String jugwan;
    private float latitude;
    private float longitude;

}
