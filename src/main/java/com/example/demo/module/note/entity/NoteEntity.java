package com.example.demo.module.note.entity;


import com.example.demo.common.enumstatus.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "NOTE_ENTRY")
public class NoteEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "NOTE_ID_SEQ")
    @SequenceGenerator(name = "NOTE_ID_SEQ" , sequenceName = "ID_SEQ" , allocationSize = 50)
    @Column( name = "ntId")
    private Long id ;

    @Column( name = "noteTitle" , nullable = false )
    private String title ;

    @Column( name = "noteContent" , nullable = false )
    private String content ;

    @Column( name = "ntStatus" , nullable = false )
    private StatusEnum ntStatus = StatusEnum.A;

}
