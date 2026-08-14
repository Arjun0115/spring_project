package com.example.demo.module.notecatagore.dto.request;


import com.example.demo.common.enumstatus.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteCatagoreFilterRequestDTO {

    private Long ntId ;

    private Long ctId ;

    private StatusEnum status ;

    private Long searchById ;

    private String globalSearch ;

}
