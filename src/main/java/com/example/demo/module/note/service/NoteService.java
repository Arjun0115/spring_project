package com.example.demo.module.note.service;

import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;


import java.util.List;


public interface NoteService {

    NoteResponseDTO create(NoteRequestDTO request) ;

    List<NoteResponseDTO> findAll() ;

    NoteResponseDTO findById(Long Id) ;

    NoteResponseDTO update(Long id , NoteRequestDTO request) ;

    NoteResponseDTO delete(Long id) ;

}
