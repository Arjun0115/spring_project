package com.example.demo.module.note.mapper.impl;

import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;
import com.example.demo.module.note.entity.NoteEntity;
import com.example.demo.module.note.mapper.NoteMapper;
import com.example.demo.module.note.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class NoteMapperImpl implements NoteMapper {

    private final NoteRepository repository ;


    @Override
    public NoteEntity toEntity(NoteRequestDTO request){
        NoteEntity entity = new NoteEntity();

        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());

        return entity ;
    }

    @Override
    public NoteResponseDTO toResponse(NoteEntity entity){
        NoteResponseDTO response = new NoteResponseDTO();

        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setContent(entity.getContent());

        return response;
    }

    @Override
    public NoteEntity update(Long id , NoteRequestDTO request){

        NoteEntity entity = repository.findById(id).orElseThrow();

        if(request.getTitle() != null){
            entity.setTitle(request.getTitle());
        }

        if(request.getContent() != null){
            entity.setContent(request.getContent());
        }



        return  entity ;
    }

    @Override
    public List<NoteResponseDTO> toResponseList( List<NoteEntity> entitys){

        return entitys.stream().map(this::toResponse).toList();
    }





}
