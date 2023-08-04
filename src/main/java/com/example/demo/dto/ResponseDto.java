package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "set") //고정된 이름으로 쓰겠다.
public class ResponseDto <D> {
    private boolean result;
    private String message;
    private D data;

    //성공했을때 만들어주는 인스턴스
    public static <D> ResponseDto<D> setSuccess(String message, D data){
        return ResponseDto.set(true, message, data);
    } 
    
    //실패했을때 만들어주는 인스턴스
    public static <D> ResponseDto<D> setFailed(String message){
        return ResponseDto.set(false, message, null);
    }
}
