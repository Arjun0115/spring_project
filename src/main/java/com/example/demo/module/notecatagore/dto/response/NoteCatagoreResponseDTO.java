package com.example.demo.module.notecatagore.dto.response;


import com.example.demo.module.catagore.dto.response.CatagoreResponseDTO;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.note.dto.response.NoteResponseDTO;
import com.example.demo.module.note.entity.NoteEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteCatagoreResponseDTO {

    private Long id ;

    private CatagoreResponseDTO category;

    private NoteResponseDTO note ;
}
