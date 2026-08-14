package com.example.demo.common.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

public class ResponseBuilder {

    private  ResponseBuilder(){

    }

    private static String getCurrentPath() {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .getPath();
    }

    public static <T> ResponseEntity<ApiResponse<T>> fetch(String message , T data ){

        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message)
                .timestamp(LocalDateTime.now())
                .path(getCurrentPath())
                .data(data)
                .build() ;

        return ResponseEntity.status(HttpStatus.OK.value()).body(response) ;
    }

}
