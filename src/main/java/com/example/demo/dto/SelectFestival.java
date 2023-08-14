package com.example.demo.dto;

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
@Table(name="selectfestival")
public class SelectFestival {
    // id가 중복되면 findall 할떼 중복되는 첫번째 값만 나옴
 
    private String sido;
    @Id
    private String sigungu;
}
