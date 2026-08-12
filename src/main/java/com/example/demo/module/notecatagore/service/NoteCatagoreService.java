package com.example.demo.module.notecatagore.service;

import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreFilterRequestDTO;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.request.SingleNoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;

import java.util.List;

public interface NoteCatagoreService {

    List<NoteCatagoreResponseDTO> create(NoteCatagoreRequestDTO request) ;

    List<NoteCatagoreResponseDTO> getAll(NoteCatagoreFilterRequestDTO filter) ;

    NoteCatagoreResponseDTO update(Long Id , SingleNoteCatagoreRequestDTO request) ;

    NoteCatagoreResponseDTO softDelete(Long Id) ;

    NoteCatagoreResponseDTO hardDelete(Long Id) ;


}
