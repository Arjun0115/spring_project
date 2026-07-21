package com.example.demo.service.impl;

import com.example.demo.entity.NoteEntry;
import com.example.demo.repository.NoteRepository;
import com.example.demo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServiceImpl implements NoteService {

    private NoteRepository repository;

    @Override
    public NoteEntry create(NoteEntry entry){
       return repository.save(entry) ;
    }

    @Override
    public List<NoteEntry> findAll(){
        return repository.findAll();
    }

}
