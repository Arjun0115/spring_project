package com.example.demo.module.note.service.impl;

import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;
import com.example.demo.module.note.entity.NoteEntity;
import com.example.demo.module.note.mapper.NoteMapper;
import com.example.demo.module.note.repository.NoteRepository;
import com.example.demo.module.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;
    private final NoteMapper mapper;


    @Override
    public NoteResponseDTO create(NoteRequestDTO request){

        if(request.getTitle() != null && request.getContent() != null){

            NoteEntity entity = mapper.toEntity(request) ;

            NoteEntity save = repository.save(entity) ;


            return mapper.toResponse(save);
        }


       return null ;
    }

    @Override
    public List<NoteResponseDTO> findAll(){

        List<NoteEntity> entities = repository.findAll() ;

        return mapper.toResponseList(entities);
    }

    @Override
    public NoteResponseDTO findById(Long id){

        NoteEntity entity = repository.findById(id).orElseThrow() ;



        return mapper.toResponse(entity) ;
    }

    @Override
    public NoteResponseDTO delete(Long id) {
        NoteEntity entity =  repository.findById(id).orElseThrow() ;
        repository.deleteById(id);

        NoteResponseDTO response = mapper.toResponse(entity) ;
        return response ;
    }

    @Override
    public NoteResponseDTO update(Long id , NoteRequestDTO request){
        NoteEntity entity = mapper.update( id , request) ;
        repository.save(entity) ;
        return mapper.toResponse(entity) ;
    }
}
