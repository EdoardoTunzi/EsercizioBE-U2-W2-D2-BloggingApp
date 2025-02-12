package com.example.EsercizioBE_U2_W2_D2_BloggingApp.controller;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.service.AutoreService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    AutoreService autoreService;

    //ok
    /*@GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }*/
    //esempio getAll con paginazione
    @GetMapping
    public Page<Autore> getAutori(@RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "10") int size,
                          @RequestParam(defaultValue = "id") String sortBy) {
        return autoreService.getAutori(page, size, sortBy);
    }

    //ok
    @GetMapping("/{id}")
    public ResponseEntity<Autore> ricercaById(@PathVariable Long id) {
        Optional<Autore> autoreRicercato = autoreService.getAutoreById(id);
        if(autoreRicercato.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(autoreRicercato.get(),HttpStatus.OK);
        }
    }
    //ok
    @PostMapping
    public String nuovoAutore(@RequestBody Autore nuovoAutore) {
        Long idGenerato = autoreService.addAutore(nuovoAutore);
        return "Autore inserito in DB con id: " + idGenerato;
    }
}
