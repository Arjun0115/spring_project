package com.example.demo.module.note.controller;

import com.example.demo.common.apiconstant.Apiconstant;
import com.example.demo.common.response.ApiResponse;
import com.example.demo.common.response.ResponseBuilder;
import com.example.demo.module.note.dto.request.NoteFilterDTO;
import com.example.demo.module.note.dto.request.NoteRequestDTO;
import com.example.demo.module.note.dto.response.NoteResponseDTO;
import com.example.demo.module.note.service.NoteService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(Apiconstant.NOTE)
@RequiredArgsConstructor
public class NoteController {

    private final NoteService service ;

    @PostMapping
    public ResponseEntity<ApiResponse<NoteResponseDTO>> create(@RequestBody NoteRequestDTO request){

              NoteResponseDTO response = service.create(request) ;

              return ResponseBuilder.create("Note" , response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> update(@PathVariable Long id ,
            @Validated @RequestBody NoteRequestDTO request){

        NoteResponseDTO response = service.update(id , request) ;

        return ResponseBuilder.update("Note" , response) ;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> findAll(NoteFilterDTO filter){

        List<NoteResponseDTO> responses = service.findAll(filter);

        return ResponseBuilder.fetch("Note" , responses) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> getById(@PathVariable Long id){

        List<NoteResponseDTO> response = service.findById(id) ;

        return ResponseBuilder.fetch("Note" , response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> softDelete(@PathVariable Long id){

        NoteResponseDTO response = service.softDelete(id);

        return ResponseBuilder.delete("Note" , response);
    }

    @DeleteMapping("/hard/{id}")
    public ResponseEntity<ApiResponse<NoteResponseDTO>> hardDelete(@PathVariable Long id){

        NoteResponseDTO response = service.hardDelete(id);

        return ResponseBuilder.delete("Note" , response);
    }


}
