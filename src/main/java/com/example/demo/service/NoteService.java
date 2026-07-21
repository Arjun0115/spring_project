package com.example.demo.service;

import com.example.demo.entity.NoteEntry;

import java.util.List;


public interface NoteService {

    NoteEntry create(NoteEntry entry) ;

    List<NoteEntry> findAll() ;


}
