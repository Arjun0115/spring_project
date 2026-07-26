package com.example.demo.module.catagore.service;

import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;

import java.util.List;

public interface CatagoreService {

    CatagoreResponseDTO create(CatagoreRequestDTO request) ;

    CatagoreResponseDTO update(Long id , CatagoreRequestDTO request) ;

    List<CatagoreResponseDTO> getAll() ;

    CatagoreResponseDTO findById(Long id);

    CatagoreResponseDTO softDelete(Long id) ;

    CatagoreResponseDTO hardDelete(Long id) ;



}
