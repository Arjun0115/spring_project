package com.example.demo.module.notecatagore.service;

import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;

public interface NoteCatagoreService {

    NoteCatagoreResponseDTO create(NoteCatagoreRequestDTO request) ;
}
