package com.example.demo.module.catagore.service;

import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.module.catagore.dto.request.CatagoreFilterDTO;
import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.specification.CatagoreSpecification;

import java.util.List;

public interface CatagoreService {

    CatagoreResponseDTO create(CatagoreRequestDTO request) ;

    CatagoreResponseDTO update(Long id , CatagoreRequestDTO request) ;

    List<CatagoreResponseDTO> getAll(CatagoreFilterDTO filter) ;

    List<CatagoreResponseDTO> findById(Long id) throws ResourceNotFoundException;

    CatagoreResponseDTO softDelete(Long id) ;

    CatagoreResponseDTO hardDelete(Long id) ;



}
