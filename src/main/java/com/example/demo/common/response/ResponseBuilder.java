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

    // create
    public static <T> ResponseEntity<ApiResponse<T>> create(String message , T data){
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message(message + " created successfully")
                .timestamp(LocalDateTime.now())
                .path(getCurrentPath())
                .data(data)
                .build() ;

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(response) ;
    }

    // fetch data
    public static <T> ResponseEntity<ApiResponse<T>> fetch(String message , T data ){

        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message + " fetch data")
                .timestamp(LocalDateTime.now())
                .path(getCurrentPath())
                .data(data)
                .build() ;

        return ResponseEntity.status(HttpStatus.OK.value()).body(response) ;
    }

    public static <T> ResponseEntity<ApiResponse<T>> update(String message , T data){
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message + " update successfully")
                .timestamp(LocalDateTime.now())
                .path(getCurrentPath())
                .data(data)
                .build() ;

        return ResponseEntity.status(HttpStatus.OK.value()).body(response) ;
    }

    public static <T> ResponseEntity<ApiResponse<T>> delete(String message , T data){
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message(message + " delete successfully")
                .timestamp(LocalDateTime.now())
                .path(getCurrentPath())
                .data(data)
                .build() ;

        return ResponseEntity.status(HttpStatus.OK.value()).body(response) ;
    }


}
