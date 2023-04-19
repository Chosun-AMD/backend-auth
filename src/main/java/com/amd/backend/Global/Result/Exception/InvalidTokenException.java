package com.amd.backend.Global.Result.Exception;

/**
 * 유효하지 않은 토큰일 경우 발생하는 예외입니다.
 *
 * @author : 황시준
 * @since : 1.0
 */
public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String invalidToken){
        super("Invalid Token " + invalidToken);
    }
}
