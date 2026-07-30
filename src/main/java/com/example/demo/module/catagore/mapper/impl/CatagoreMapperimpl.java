package com.example.demo.module.catagore.mapper.impl;


import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.catagore.mapper.CatagoreMapper;
import com.example.demo.module.catagore.repository.CatagoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CatagoreMapperimpl implements CatagoreMapper {

    private final CatagoreRepository repository ;

    @Override
    public CatagoreEntity toEntity(CatagoreRequestDTO request){

        CatagoreEntity entity = new CatagoreEntity();

        if(request.getCtName() != null){
            entity.setCtName(request.getCtName());
        }

        return entity ;
    }

    @Override
    public CatagoreResponseDTO toRespose(CatagoreEntity entity){
        CatagoreResponseDTO response = new CatagoreResponseDTO() ;
        response.setCtId(entity.getCtId());
        response.setCtName(entity.getCtName());
        return response ;
    }


    @Override
    public List<CatagoreResponseDTO> toListRespose(List<CatagoreEntity> entities){

        return entities.stream().map(this::toRespose).toList();
    }

    @Override
    public CatagoreEntity update(Long id, CatagoreRequestDTO reqeust){

        CatagoreEntity entity = repository.findById(id).orElseThrow();

        entity.setCtName(reqeust.getCtName());

        return entity ;
    }




}
