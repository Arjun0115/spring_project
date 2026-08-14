package com.example.demo.common.response;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean success ;

    private int status ;

    private String message ;

    private String path ;

    private LocalDateTime timestamp ;

    private T data ;



}
