package com.example.EsercizioBE_U2_W2_D2_BloggingApp.controller;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    AutoreService autoreService;

    @GetMapping
    public List<Autore> getAllPost() {
        return autoreService.getAllAutori();
    }

    @GetMapping("/{id}")
    public Optional<Autore> getAutoreById(@PathVariable long id) {
        return autoreService.getAutoreById(id);
    }
}
