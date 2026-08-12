package com.example.demo.module.note.entity;


import com.example.demo.common.enumstatus.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "mm_note")
public class NoteEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column( name = "ntId")
    private Long id ;

    @Column( name = "ntTitle" , nullable = false )
    private String title ;

    @Column( name = "ntContent" , nullable = false )
    private String content ;

    @Column( name = "ntStatus" , nullable = false )
    private StatusEnum ntStatus = StatusEnum.A;

}
