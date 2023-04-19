package com.amd.backend.Global.Result.Exception;

/**
 * Authorization Header 정보가 없거나 유효하지 않은 JWT 토큰일 때 발생하는 예외
 *
 * @author : 황시준
 * @since : 1.0
 */
public class InvalidAuthorizationHeaderException extends RuntimeException{
    private static final String MESSAGE = "Header 정보가 없거나 유효하지 않은 토큰입니다.";

    public InvalidAuthorizationHeaderException(){
        super(MESSAGE);
    }
}