package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //롬복의 @Getter / @Setter, @ToString, @EqualsAndHashCode와 @RequiredArgsConstructor, @Value 를 합쳐놓은 종합 선물 세트
public class SignUpDto {
    private String userId;
    private String userPassword;
    private String userPasswordCheck;
    private String userName;
    private String userRole;

    
}
