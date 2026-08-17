package com.example.demo.module.note.service.impl;

import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.module.note.dto.request.NoteFilterDTO;
import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;
import com.example.demo.module.note.entity.NoteEntity;
import com.example.demo.module.note.mapper.NoteMapper;
import com.example.demo.module.note.repository.NoteRepository;
import com.example.demo.module.note.service.NoteService;
import com.example.demo.module.note.specification.NoteSpecification;
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
    public NoteResponseDTO update(Long id , NoteRequestDTO request){

        repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found"));

        NoteEntity entity = mapper.update( id , request) ;

        entity = repository.save(entity) ;

        return mapper.toResponse(entity) ;
    }

    @Override
    public List<NoteResponseDTO> findAll(NoteFilterDTO filter){

        List<NoteEntity> entities = repository.findAll(NoteSpecification.filter(filter)) ;

        return mapper.toResponseList(entities);
    }

    @Override
    public List<NoteResponseDTO>  findById(Long id){

        repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;

        NoteFilterDTO filter = new NoteFilterDTO() ;
        filter.setId(id);

        List<NoteEntity> entity = repository.findAll(NoteSpecification.filter(filter)) ;

        return mapper.toResponseList(entity) ;
    }

    @Override
    public NoteResponseDTO softDelete(Long Id){

        NoteEntity entity = repository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;

        entity.setNtStatus(StatusEnum.X);

        entity = repository.save(entity) ;
        
        return mapper.toResponse(entity) ;
    }

    @Override
    public NoteResponseDTO hardDelete(Long id) {

        NoteEntity entity =  repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;

        NoteResponseDTO response = mapper.toResponse(entity) ;

        repository.deleteById(id);

        return response ;
    }


}
