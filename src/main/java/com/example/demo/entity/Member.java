package com.example.demo.entity;

import com.example.demo.dto.SignUpDto;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    private String userId;
    private String userPassword;
    private String userName;
    private String userRole;

    public Member(SignUpDto dto){
        this.userId = dto.getUserId();
        this.userPassword =dto.getUserPassword();
        this.userName = dto.getUserName();
        this.userRole =dto.getUserRole();
    }
}
