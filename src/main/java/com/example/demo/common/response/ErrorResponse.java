package com.example.demo.common.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse<T> {
    private boolean success ;

    private int status ;

    private String message ;

    private String path ;

    private T data ;

    private LocalDateTime timestamp ;

    private Object error ;

}
