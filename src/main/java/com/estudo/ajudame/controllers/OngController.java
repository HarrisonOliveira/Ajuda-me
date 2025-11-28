package com.estudo.ajudame.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @PostMapping
    public String cadastroOng(String world){
        return "Hello " + world;
    }
}
