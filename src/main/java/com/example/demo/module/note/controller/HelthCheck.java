package com.example.demo.module.note.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HelthCheck {

    @GetMapping
    public String g(){
        return "ok" ;
    }
}
