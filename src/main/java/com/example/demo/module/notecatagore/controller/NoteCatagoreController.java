package com.example.demo.module.notecatagore.controller;


import com.example.demo.common.apiconstant.Apiconstant;
import com.example.demo.common.response.ApiResponse;
import com.example.demo.common.response.ResponseBuilder;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreFilterRequestDTO;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.request.SingleNoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.service.NoteCatagoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Apiconstant.NOTECATAGORE)
public class NoteCatagoreController {

    private final NoteCatagoreService service ;

    @PostMapping
    public ResponseEntity<ApiResponse<List<NoteCatagoreResponseDTO>>> create(@RequestBody NoteCatagoreRequestDTO request){

        List<NoteCatagoreResponseDTO> response = service.create(request) ;

        return ResponseBuilder.create("Note Catagore association" , response) ;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<NoteCatagoreResponseDTO>>> getAll(NoteCatagoreFilterRequestDTO filter){

        List<NoteCatagoreResponseDTO> response = service.getAll(filter);

        return ResponseBuilder.fetch( "Note Catagore association" , response);

    }

    @GetMapping("/note/{id}")
    public ResponseEntity<ApiResponse<List<NoteCatagoreResponseDTO>>> getByNoteId(@PathVariable Long id){

        List<NoteCatagoreResponseDTO> response = service.getByNoteId(id) ;

        return ResponseBuilder.fetch( "Note Catagore association" , response);

    }

    @GetMapping("/catagore/{id}")
    public ResponseEntity<ApiResponse<List<NoteCatagoreResponseDTO>>> getByCatagoreId (@PathVariable Long id){

        List<NoteCatagoreResponseDTO> response = service.getByCatagoreId(id) ;

        return ResponseBuilder.fetch( "Note Catagore association" , response);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ApiResponse<NoteCatagoreResponseDTO>> update( @PathVariable Long id ,
             @RequestBody SingleNoteCatagoreRequestDTO request){

        NoteCatagoreResponseDTO response = service.update(id , request) ;

        return ResponseBuilder.update( "Note Catagore association" , response);

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<ApiResponse<NoteCatagoreResponseDTO>> softDelete(@PathVariable Long id){

        NoteCatagoreResponseDTO response = service.softDelete(id) ;

        return ResponseBuilder.delete( "Note Catagore association" , response);
    }


    @DeleteMapping("/hard/{id}")
    public  ResponseEntity<ApiResponse<NoteCatagoreResponseDTO>> hardDelete( @PathVariable Long id){

        NoteCatagoreResponseDTO response = service.hardDelete(id);

        return ResponseBuilder.delete( "Note Catagore association" , response);
    }
}
