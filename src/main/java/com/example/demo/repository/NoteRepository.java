package com.example.demo.repository;


import com.example.demo.entity.NoteEntry;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NoteRepository extends JpaRepository<NoteEntry , Long> {






}
