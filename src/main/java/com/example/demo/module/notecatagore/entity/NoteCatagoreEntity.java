package com.example.demo.module.notecatagore.entity;

import com.example.demo.common.enumstatus.StatusEnum;
import com.example.demo.module.catagore.entity.CatagoreEntity;
import com.example.demo.module.note.entity.NoteEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "tm_note_catagore")
@Getter
@Setter
public class NoteCatagoreEntity {

    @Id
    @Column(name = "tmId")
    private Long id ;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "ntId")
    private NoteEntity note ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ctId" , nullable = false)
    private CatagoreEntity category;

    @Column(name = "tm_nc_status")
    private StatusEnum status = StatusEnum.A ;

}
