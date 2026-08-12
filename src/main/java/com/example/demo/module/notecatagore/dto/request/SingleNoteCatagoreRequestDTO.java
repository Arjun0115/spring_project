package com.example.demo.module.notecatagore.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class SingleNoteCatagoreRequestDTO {

    private Long id ;

    private Long categoryId;

    private Long noteId ;

}
