package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MeberRepository;

//AuthController의 대한 기능을 구현하기 위해 만드는 클래스
@Service
public class AuthService {
    @Autowired
    MeberRepository meberRepository;

    public ResponseDto<?> signUp(SignUpDto dto){
        String userId = dto.getUserId();
        String userPassword =dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // id 중복확인
        try {
            if(meberRepository.existsById(userId))
                return ResponseDto.setFailed("중복된 아이디입니다.");
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터 베이스 에러");
        };
        //Repository에 관련된 기능은 예외처리해줌


        
        // 비밀번호가 서로 다르면 failed response반환!
        if (!userPassword.equals(userPasswordCheck)){
            return ResponseDto.setFailed("비밀번호가 다릅니다.");
        }
        
        //Member entitiy  생성
        Member member = new Member(dto);
        
        // MemberRepo를 이용해서 데이터베이스에 member entity저장!
        try {
            meberRepository.save(member);

        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 에러");
            
        }
        
        //성공시 success response 반환
        return ResponseDto.setSuccess("회원가입 성공", null);
    }

}
