package com.example.demo.module.catagore.mapper;

import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CatagoreMapper {

    CatagoreEntity toEntity(CatagoreRequestDTO reqeust) ;

    CatagoreResponseDTO toRespose(CatagoreEntity entity);

    List<CatagoreResponseDTO> toListRespose(List<CatagoreEntity> entities);

    CatagoreEntity update(Long id, CatagoreRequestDTO reqeust);
}
