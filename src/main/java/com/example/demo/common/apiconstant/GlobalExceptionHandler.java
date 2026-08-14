package com.example.demo.common.apiconstant;


import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.common.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse<Void>> handleResourceNotFoundException(ResourceNotFoundException e , HttpServletRequest request){

        ErrorResponse<Void> response = new ErrorResponse<>() ;

        response.setSuccess(false);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(LocalDateTime.now()); ;
        response.setError("Resource not found");
        response.setPath(request.getServletPath());



        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response) ;
    }
}
