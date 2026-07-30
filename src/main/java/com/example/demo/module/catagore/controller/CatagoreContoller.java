package com.example.demo.module.catagore.controller;


import com.example.demo.common.apibank.apiLinks.Apiurl;
import com.example.demo.module.catagore.dto.request.CatagoreRequestDTO;
import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.repository.CatagoreRepository;
import com.example.demo.module.catagore.service.CatagoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Apiurl.CATAGORE)
@RequiredArgsConstructor
public class CatagoreContoller {

    private final CatagoreService service ;
    private final CatagoreRepository repository ;

    @PostMapping
    public CatagoreResponseDTO create(@RequestBody CatagoreRequestDTO request){

        CatagoreResponseDTO response = service.create(request) ;

        return response ;
    }

    @GetMapping
    public List<CatagoreResponseDTO> finlAll(){
        List<CatagoreResponseDTO> listresponse = service.getAll();

        return listresponse ;
    }

    @PutMapping("/{id}")
    public CatagoreResponseDTO update( @PathVariable Long id  , @RequestBody CatagoreRequestDTO request){

        CatagoreResponseDTO response = service.update(id , request) ;

        return response ;
    }

    @GetMapping("/{id}")
    public CatagoreResponseDTO getById (@PathVariable Long id) throws Exception  {
        CatagoreResponseDTO response = service.findById(id) ;
        return response ;
    }

//    @DeleteMapping("/{id}")
//    public CatagoreResponseDTO softDelte(@PathVariable Long id){
//
//        CatagoreResponseDTO response = service.softDelete(id) ;
//
//        return response ;
//
//    }

    @DeleteMapping("/hard{id}")
    public CatagoreResponseDTO hardDelete(@PathVariable Long id){
        CatagoreResponseDTO response = service.hardDelete(id) ;

        return response ;
    }

}
