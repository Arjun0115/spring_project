package com.example.demo.module.catagore.service.impl;

import com.example.demo.common.enumstatus.ColumnStatus;
import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.catagore.mapper.CatagoreMapper;
import com.example.demo.module.catagore.repository.CatagoreRepository;
import com.example.demo.module.catagore.service.CatagoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatagoreServiceimpl implements CatagoreService {

    private final CatagoreRepository repository ;

    private final CatagoreMapper mapper ;


    @Override
    public CatagoreResponseDTO create(CatagoreRequestDTO request){
        CatagoreEntity entity = new CatagoreEntity();

        entity.setCtName(request.getCtName());

        return mapper.toRespose(entity) ;
    }

    @Override
    public CatagoreResponseDTO update(Long id , CatagoreRequestDTO request){
        CatagoreEntity entity = repository.findById(id).orElseThrow();

        entity.setCtName(request.getCtName());

        return mapper.toRespose(repository.save(entity));
    }

    @Override
    public CatagoreResponseDTO findById(Long id){

        CatagoreEntity entity = repository.findById(id).orElseThrow();

        return mapper.toRespose(entity) ;
    }

    @Override
    public List<CatagoreResponseDTO> getAll(){

        List<CatagoreEntity> entities = repository.findAll();

        return mapper.toListRespose(entities) ;
    }

    @Override
    public CatagoreResponseDTO softDelete(Long id){

        CatagoreEntity entity = repository.findById(id).orElseThrow() ;

        CatagoreResponseDTO response = mapper.toRespose(entity);

        entity.setCtStatus(ColumnStatus.X);

        return response ;

    }


    @Override
    public CatagoreResponseDTO hardDelete(Long id){

        CatagoreEntity entity = repository.findById(id).orElseThrow() ;

        CatagoreResponseDTO response = mapper.toRespose(entity);

        repository.delete(entity);

        return response ;

    }




}
