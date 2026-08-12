package com.example.demo.module.notecatagore.mapper;


import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.entity.NoteCatagoreEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteCatagoreMapper {

    NoteCatagoreResponseDTO toResponse(NoteCatagoreEntity entity) ;

    List<NoteCatagoreResponseDTO> toResponseList( List<NoteCatagoreEntity> entity) ;
}
