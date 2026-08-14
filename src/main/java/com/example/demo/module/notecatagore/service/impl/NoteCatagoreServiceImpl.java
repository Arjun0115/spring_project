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
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class NoteCatagoreServiceImpl implements NoteCatagoreService {

    private final NoteCatagoreMapper mapper ;
    private final NoteCatagoreReposotry repository;
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

            savedEntities.add(repository.save(entity)) ;
        }

        return mapper.toResponseList(savedEntities) ;

    }

    @Override
    public List<NoteCatagoreResponseDTO> getAll(NoteCatagoreFilterRequestDTO filter){

        List<NoteCatagoreEntity> entities = repository.findAll(
                 NoteCatagoreSpecification.filter(filter)
        ) ;

        return mapper.toResponseList(entities) ;
    }

    @Override
    public List<NoteCatagoreResponseDTO> getByNoteId(Long Id) {

        noteRepository.findById(Id).orElseThrow(
                ()-> new ResourceNotFoundException("Note not found")
        ) ;

        repository.findById(Id).orElseThrow(
                ()-> new ResourceNotFoundException("Note not found")
        );


        NoteCatagoreFilterRequestDTO filter = new NoteCatagoreFilterRequestDTO() ;
        filter.setNtId(Id);

        List<NoteCatagoreEntity> entities = repository.findAll(NoteCatagoreSpecification.filter(filter)) ;

        return mapper.toResponseList(entities) ;
    }

    @Override
    public List<NoteCatagoreResponseDTO> getByCatagoreId(Long Id) {

        catagoreRepository.findById(Id).orElseThrow(
                ()-> new ResourceNotFoundException("Catagore not found")
        ) ;

        repository.findById(Id).orElseThrow(
                ()-> new ResourceNotFoundException("Catagore not found")
        );

        NoteCatagoreFilterRequestDTO filter = new NoteCatagoreFilterRequestDTO() ;
        filter.setCtId(Id);

        List<NoteCatagoreEntity> entities = repository.findAll(NoteCatagoreSpecification.filter(filter)) ;

        return mapper.toResponseList(entities) ;
    }


    @Override
    public NoteCatagoreResponseDTO update(Long Id , SingleNoteCatagoreRequestDTO request){

        NoteCatagoreEntity entity = repository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note Catagore not found")) ;

        CatagoreEntity catagoreEntity = catagoreRepository.findById(request.getCategoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Catagore not found")) ;

        NoteEntity noteEntity = noteRepository.findById(request.getNoteId())
                .orElseThrow(()-> new ResourceNotFoundException("Note not found")) ;


        entity.setCategory(catagoreEntity);
        entity.setNote(noteEntity);

        entity = repository.save(entity) ;

        return mapper.toResponse(entity) ;
    }



    @Override
    public NoteCatagoreResponseDTO softDelete(Long Id){

        NoteCatagoreEntity entity = repository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note Catagore not found")) ;

        NoteCatagoreResponseDTO response = mapper.toResponse(entity) ;

        entity.setStatus(StatusEnum.X);

        entity = repository.save(entity) ;

        return response ;
    }

    @Override
    public NoteCatagoreResponseDTO hardDelete(Long Id){

        NoteCatagoreEntity entity = repository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Note Catagore not found")) ;

        NoteCatagoreResponseDTO response = mapper.toResponse(entity) ;

        repository.delete(entity);

        return response ;
    }






}
