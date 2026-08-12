package com.example.demo.module.notecatagore.service.impl;

import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.catagore.repository.CatagoreRepository;
import com.example.demo.module.note.entity.NoteEntity;
import com.example.demo.module.note.repository.NoteRepository;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreFilterRequestDTO;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.request.SingleNoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.entity.NoteCatagoreEntity;
import com.example.demo.module.notecatagore.mapper.NoteCatagoreMapper;
import com.example.demo.module.notecatagore.repository.NoteCatagoreReposotry;
import com.example.demo.module.notecatagore.service.NoteCatagoreService;
import com.example.demo.module.notecatagore.specification.NoteCatagoreSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.events.Event;

import java.util.List;


@Component
@RequiredArgsConstructor
public class NoteCatagoreServiceImpl implements NoteCatagoreService {

    private final NoteCatagoreMapper mapper ;
    private final NoteCatagoreReposotry reposotry ;
    private final NoteRepository noteRepository ;
    private final CatagoreRepository catagoreRepository ;


    @Override
    public List<NoteCatagoreResponseDTO> create(NoteCatagoreRequestDTO request){

        CatagoreEntity catagoreEntity = catagoreRepository.findById(request.getCategoryId()).orElseThrow() ;

        List<NoteCatagoreEntity> savedEntities = new java.util.ArrayList<>() ;

        for(Long noteId : request.getNoteIds()){

            NoteEntity noteEntity = noteRepository.findById(noteId).orElseThrow();

            NoteCatagoreEntity entity = new NoteCatagoreEntity() ;
            entity.setNote(noteEntity);
            entity.setCategory(catagoreEntity);

            savedEntities.add(reposotry.save(entity)) ;
        }

        return mapper.toResponseList(savedEntities) ;

    }

    @Override
    public List<NoteCatagoreResponseDTO> getAll(NoteCatagoreFilterRequestDTO filter){

        List<NoteCatagoreEntity> entities = reposotry.findAll(
                 NoteCatagoreSpecification.filter(filter)
        ) ;

        return mapper.toResponseList(entities) ;
    }


    @Override
    public NoteCatagoreResponseDTO update(Long Id , SingleNoteCatagoreRequestDTO request){

        NoteCatagoreEntity entity = reposotry.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note Catagore not found")) ;

        CatagoreEntity catagoreEntity = catagoreRepository.findById(request.getCategoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Catagore not found")) ;

        NoteEntity noteEntity = noteRepository.findById(request.getNoteId())
                .orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;


        entity.setCategory(catagoreEntity);
        entity.setNote(noteEntity);

        entity = reposotry.save(entity) ;

        return mapper.toResponse(entity) ;
    }

    @Override
    public NoteCatagoreResponseDTO softDelete(Long Id){

        NoteCatagoreEntity entity = reposotry.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note Catagore not found")) ;

        NoteCatagoreResponseDTO response = mapper.toResponse(entity) ;

        entity.setStatus(StatusEnum.X);

        entity = reposotry.save(entity) ;

        return response ;
    }

    @Override
    public NoteCatagoreResponseDTO hardDelete(Long Id){

        NoteCatagoreEntity entity = reposotry.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note Catagore not found")) ;

        NoteCatagoreResponseDTO response = mapper.toResponse(entity) ;

        reposotry.delete(entity);

        return response ;
    }






}
