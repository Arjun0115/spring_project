package com.example.demo.module.catagore.controller;

import com.example.demo.common.apiconstant.Apiconstant;
import com.example.demo.common.response.ApiResponse;
import com.example.demo.common.response.ResponseBuilder;
import com.example.demo.module.catagore.dto.request.CatagoreFilterDTO;
import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.service.CatagoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Apiconstant.CATAGORE)
@RequiredArgsConstructor
public class CatagoreController {

    private final CatagoreService service;

    @PostMapping
    public ResponseEntity<ApiResponse<CatagoreResponseDTO>> create( @RequestBody CatagoreRequestDTO request ) {

        CatagoreResponseDTO response = service.create(request);

        return ResponseBuilder.create("Catagore",  response );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CatagoreResponseDTO>>> findAll( CatagoreFilterDTO filter) {

        List<CatagoreResponseDTO> responses = service.getAll(filter);

        return ResponseBuilder.fetch("Catagore", responses );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CatagoreResponseDTO>> update(@PathVariable Long id,
            @RequestBody CatagoreRequestDTO request ) {

        CatagoreResponseDTO response =  service.update(id, request);

        return ResponseBuilder.update( "Catagore", response );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<CatagoreResponseDTO>>> getById( @PathVariable Long id ) {

        List<CatagoreResponseDTO> response =  service.findById(id);

        return ResponseBuilder.fetch( "Catagore", response );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CatagoreResponseDTO>> softDelete( @PathVariable Long id){

        CatagoreResponseDTO response = service.softDelete(id) ;

        return ResponseBuilder.delete( "Catagore" , response) ;
    }

    @DeleteMapping("/hard/{id}")
    public ResponseEntity<ApiResponse<CatagoreResponseDTO>> hardDelete( @PathVariable Long id ) {

        CatagoreResponseDTO response = service.hardDelete(id);

        return ResponseBuilder.delete("Catagore", response );
    }
}