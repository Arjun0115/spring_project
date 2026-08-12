package com.example.demo.module.notecatagore.controller;


import com.example.demo.common.apibank.apiLinks.Apiurl;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreFilterRequestDTO;
import com.example.demo.module.notecatagore.dto.request.NoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.request.SingleNoteCatagoreRequestDTO;
import com.example.demo.module.notecatagore.dto.response.NoteCatagoreResponseDTO;
import com.example.demo.module.notecatagore.repository.NoteCatagoreReposotry;
import com.example.demo.module.notecatagore.service.NoteCatagoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Apiurl.NOTECATAGORE)
public class NoteCatagoreController {

    private final NoteCatagoreService service ;

    @PostMapping
    public List<NoteCatagoreResponseDTO> create(@RequestBody NoteCatagoreRequestDTO request){

        List<NoteCatagoreResponseDTO> response = service.create(request) ;

        return response ;
    }

    @GetMapping
    public List<NoteCatagoreResponseDTO> getAll(NoteCatagoreFilterRequestDTO filter){

        List<NoteCatagoreResponseDTO> response = service.getAll(filter);

        return response ;

    }

    @PutMapping("/{id}")
    public NoteCatagoreResponseDTO update( @PathVariable Long id ,
             @RequestBody SingleNoteCatagoreRequestDTO request){

        NoteCatagoreResponseDTO response = service.update(id , request) ;

        return response ;

    }

    @DeleteMapping("/{id}")
    public NoteCatagoreResponseDTO softDelete(@PathVariable Long id){

        NoteCatagoreResponseDTO response = service.softDelete(id) ;

        return response ;
    }


    @DeleteMapping("/hard/{id}")
    public NoteCatagoreResponseDTO hardDelete( @PathVariable Long id){

        NoteCatagoreResponseDTO response = service.hardDelete(id);

        return response ;
    }
}
