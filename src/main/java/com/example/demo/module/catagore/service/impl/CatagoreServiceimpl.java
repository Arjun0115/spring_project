package com.example.demo.module.catagore.service.impl;

import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.module.catagore.dto.request.CatagoreFilterDTO;
import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.catagore.mapper.CatagoreMapper;
import com.example.demo.module.catagore.repository.CatagoreRepository;
import com.example.demo.module.catagore.service.CatagoreService;

import com.example.demo.module.catagore.specification.CatagoreSpecification;
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

        entity = repository.save(entity) ;

        return mapper.toRespose(entity) ;
    }

    @Override
    public CatagoreResponseDTO update(Long id , CatagoreRequestDTO request){

        CatagoreEntity entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found"));

        entity.setCtName(request.getCtName());

        return mapper.toRespose(repository.save(entity));
    }

    @Override
    public List<CatagoreResponseDTO> findById(Long id){

        repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;

        CatagoreFilterDTO filter = new CatagoreFilterDTO() ;
        filter.setId(id);

        List<CatagoreEntity> entity = repository.findAll(CatagoreSpecification.filter(filter)) ;



      return mapper.toListRespose(entity) ;
    }


    @Override
    public List<CatagoreResponseDTO> getAll( CatagoreFilterDTO filter ){

        List<CatagoreEntity> entities = repository.findAll(CatagoreSpecification.filter(filter));

        return mapper.toListRespose(entities) ;
    }

    @Override
    public CatagoreResponseDTO softDelete(Long id){

        CatagoreEntity entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;

        entity.setCtStatus(StatusEnum.X);

        entity = repository.save(entity) ;

        return mapper.toRespose(entity) ;

    }


    @Override
    public CatagoreResponseDTO hardDelete(Long id){

        CatagoreEntity entity = repository.findById(id).orElseThrow() ;

        CatagoreResponseDTO response = mapper.toRespose(entity);

        repository.delete(entity);

        return response ;

    }




}
