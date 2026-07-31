package com.example.demo.module.notecatagore.service.impl;

import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.catagore.repository.CatagoreRepository;
import com.example.demo.module.note.entity.NoteEntity;
import com.example.demo.module.note.repository.NoteRepository;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.entity.NoteCatagoreEntity;
import com.example.demo.module.notecatagore.mapper.NoteCatagoreMapper;
import com.example.demo.module.notecatagore.repository.NoteCatagoreReposotry;
import com.example.demo.module.notecatagore.service.NoteCatagoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class NoteCatagoreServiceImpl implements NoteCatagoreService {

    private final NoteCatagoreMapper mapper ;
    private final NoteCatagoreReposotry reposotry ;
    private final NoteRepository noteRepository ;
    private final CatagoreRepository catagoreRepository ;


    @Override
    public NoteCatagoreResponseDTO create(NoteCatagoreRequestDTO request){

        NoteCatagoreEntity entity = new NoteCatagoreEntity() ;

        for(Long id : request.getNoteIds()){

            NoteEntity noteEntity = noteRepository.findById(id).orElseThrow();
            CatagoreEntity catagoreEntity = catagoreRepository.findById(id).orElseThrow() ;



            entity.setNote(noteEntity);
            entity.setCategory(catagoreEntity);


        }

        return mapper.toResponse(entity) ;

    }

    @Override
    public List<NoteCatagoreResponseDTO> getAll(){
        List<NoteCatagoreEntity>
        return
    }



}
