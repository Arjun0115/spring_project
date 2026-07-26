package com.example.demo.module.note.controller;

import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;


import com.example.demo.module.note.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/add-note")
public class Contoller {

    @Autowired
    NoteService service ;

    @PostMapping
    public NoteResponseDTO create(@RequestBody NoteRequestDTO request){
              NoteResponseDTO response ;
              response = service.create(request) ;
              return response ;
    }

    @GetMapping
    public List<NoteResponseDTO> findAll(){
        List<NoteResponseDTO> responses = service.findAll();
        return responses ;
    }

    @GetMapping("/{id}")
    public NoteResponseDTO getById(@PathVariable Long id){
        NoteResponseDTO response = service.findById(id) ;
        return response;
    }

    @DeleteMapping("/{id}")
    public NoteResponseDTO softDelete(@PathVariable Long id){

        NoteResponseDTO response = service.delete(id);
        return response;
    }

    @DeleteMapping("/hard/{id}")
    public NoteResponseDTO hardDelete(@PathVariable Long id){

        NoteResponseDTO response = service.delete(id);
        return response;
    }

    @PutMapping("/{id}")
    public NoteResponseDTO update(@PathVariable Long id , @Validated @RequestBody NoteRequestDTO request){
        NoteResponseDTO response = service.update(id , request) ;
        return response ;
    }



}
