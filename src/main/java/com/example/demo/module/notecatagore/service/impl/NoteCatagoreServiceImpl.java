package com.example.demo.module.notecatagore.service.impl;

import com.example.demo.module.catagore.repository.CatagoreRepository;
import com.example.demo.module.note.repository.NoteRepository;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.entity.NoteCatagoteEntity;
import com.example.demo.module.notecatagore.mapper.NoteCatagoreMapper;
import com.example.demo.module.notecatagore.repository.NoteCatagoreReposotry;
import com.example.demo.module.notecatagore.service.NoteCatagoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class NoteCatagoreServiceImpl implements NoteCatagoreService {

    private final NoteCatagoreMapper mapper ;
    private final NoteCatagoreReposotry reposotry ;
    private final NoteRepository noteRepository ;
    private final CatagoreRepository catagoreRepository ;


    @Override
    public NoteCatagoreResponseDTO create(NoteCatagoreRequestDTO request){
        NoteCatagoteEntity entity = new NoteCatagoteEntity() ;

    }



}
