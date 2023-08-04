package com.example.demo.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.SignInDto;
import com.example.demo.dto.SignInResponseDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Member;
import com.example.demo.repository.MeberRepository;
import com.example.demo.security.TokenProvider;

//AuthController의 대한 기능을 구현하기 위해 만드는 클래스
@Service
public class AuthService {
    @Autowired
    MeberRepository memberRepository;
    @Autowired
    TokenProvider tokenProvider;

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userId = dto.getUserId();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // id 중복확인
        try {
            if (memberRepository.existsById(userId))
                return ResponseDto.setFailed("중복된 아이디입니다.");
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터 베이스 에러");
        }
        ;
        // Repository에 관련된 기능은 예외처리해줌

        // 비밀번호가 서로 다르면 failed response반환!
        if (!userPassword.equals(userPasswordCheck)) {
            return ResponseDto.setFailed("비밀번호가 다릅니다.");
        }

        // Member entitiy 생성
        Member member = new Member(dto);

        // MemberRepo를 이용해서 데이터베이스에 member entity저장!
        try {

            member.setUserRole("Role_Member");
            memberRepository.save(member);

        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 에러");

        }

        // 성공시 success response 반환
        return ResponseDto.setSuccess("회원가입 성공", null);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
        String userId = dto.getUserId();
        String userpassword = dto.getUserPassword();
        Member member = null;
        try {
            member = memberRepository.findById(userId).get();
        } catch (NoSuchElementException e) {
            return ResponseDto.setFailed("해당회원을 찾을 수 없습니다.");
        }
        try {
            boolean existed = memberRepository.existsByUserIdAndUserPassword(userId, userpassword);
            if (!existed)
                return ResponseDto.setFailed("로그인 정보가 일치하지 않습니다.");
        } catch (Exception e) {
            return ResponseDto.setFailed("데이터베이스 에러1");
        }

        member.setUserPassword("");

        String token = tokenProvider.create(userId);
        int exprTime = 36000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, member);
        return ResponseDto.setSuccess("로그인에 성공", signInResponseDto);

    }

}
