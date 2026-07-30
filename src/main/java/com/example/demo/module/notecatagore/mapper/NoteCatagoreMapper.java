package com.example.demo.module.notecatagore.mapper;


import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.entity.NoteCatagoteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteCatagoreMapper {

    NoteCatagoreResponseDTO toResponse(NoteCatagoteEntity entity) ;
    List<NoteCatagoreResponseDTO> toResponseList(NoteCatagoteEntity entity) ;
}
