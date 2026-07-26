package com.example.demo.module.note.repository;


import com.example.demo.module.note.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NoteRepository extends JpaRepository<NoteEntity, Long> {





}
