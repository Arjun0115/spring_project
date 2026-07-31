package com.example.demo.module.notecatagore.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NoteCatagoreRequestDTO {

    private Long id ;

    private Long categoryId;

    private List<Long> noteIds ;

}
