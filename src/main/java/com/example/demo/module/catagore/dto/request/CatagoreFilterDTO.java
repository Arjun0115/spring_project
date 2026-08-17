package com.example.demo.module.catagore.dto.request;

import com.example.demo.common.enumstatus.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatagoreFilterDTO {

    private Long Id ;

    private StatusEnum status ;

    private Long searchById ;

    private String globalSearch ;
}
