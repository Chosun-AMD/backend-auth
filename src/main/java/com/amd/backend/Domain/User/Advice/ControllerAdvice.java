package com.amd.backend.Domain.User.Advice;


import com.amd.backend.Domain.User.DTO.ResponseDTO;
import com.amd.backend.Global.Result.Exception.InvalidAuthorizationHeaderException;
import com.amd.backend.Global.Result.Exception.InvalidTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 예외 처리를 위한 Controller Advice입니다.
 * @author : 황시준
 * @since : 1.0
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(InvalidAuthorizationHeaderException.class)
    public ResponseEntity<ResponseDTO<Object>> handleInvalidAuthorizationHeaderException(Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ResponseDTO.builder()
                        .success(false)
                        .status(HttpStatus.UNAUTHORIZED)
                        .errorMessages(List.of(e.getMessage()))
                        .build()
        );
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ResponseDTO<Object>> handleInvalidTokenException(Exception e){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ResponseDTO.builder()
                        .success(false)
                        .status(HttpStatus.FORBIDDEN)
                        .errorMessages(List.of())
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<Object>> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ResponseDTO.builder()
                        .success(false)
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .errorMessages(List.of(e.getMessage()))
                        .build()
        );
    }
}
