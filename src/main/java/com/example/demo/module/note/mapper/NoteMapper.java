package com.example.demo.module.note.mapper;


import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;
import com.example.demo.module.note.entity.NoteEntity;

import java.util.List;


public interface NoteMapper {

    NoteEntity toEntity(NoteRequestDTO request) ;

    NoteResponseDTO toResponse(NoteEntity entry) ;

    List<NoteResponseDTO> toResponseList(List<NoteEntity> entries);

    NoteEntity update( Long id , NoteRequestDTO request) ;

}
