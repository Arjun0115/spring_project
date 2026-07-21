package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "NOTE_ENTRY")
public class NoteEntry {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE , generator = "NOTE_ID_SEQ")
    @SequenceGenerator(name = "NOTE_ID_SEQ" , sequenceName = "ID_SEQ" , allocationSize = 50)
    @Column( name = "ID")
    private Long id ;

    @Column( name = "NOTE_TITLE" , nullable = false )
    private String title ;

    @Column( name = "NOTE_CONTENT" , nullable = false )
    private String content ;

}
