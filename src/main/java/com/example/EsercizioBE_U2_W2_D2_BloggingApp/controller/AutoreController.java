package com.example.EsercizioBE_U2_W2_D2_BloggingApp.controller;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.AutoreDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.service.AutoreService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
        if (autoreRicercato.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(autoreRicercato.get(), HttpStatus.OK);
        }
    }

    //ok
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String nuovoAutore(@RequestBody @Validated AutoreDTO nuovoAutoreDTO) {
        Long idGenerato = autoreService.addAutore(nuovoAutoreDTO);
        return "Autore inserito in DB con id: " + idGenerato;
    }
   //ok
    @PutMapping("/{id}")
    public ResponseEntity<Autore> modificaAutoreById(@PathVariable Long id, @RequestBody AutoreDTO autoreDTO) {
        Optional<Autore> autoreRicercato = autoreService.getAutoreById(id);
        if (autoreRicercato.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        } else {
            // Recupera l'autore esistente
            Autore autoreEsistente = autoreRicercato.get();

            // Aggiorna solo i campi modificabili
            autoreEsistente.setNome(autoreDTO.getNome());
            autoreEsistente.setCognome(autoreDTO.getCognome());
            autoreEsistente.setEmail(autoreDTO.getEmail());
            autoreEsistente.setDataDiNascita(autoreDTO.getDataDiNascita());

            // Salva l'autore aggiornato nel database
            Autore autoreAggiornato = autoreService.addAutore2(autoreEsistente);

            return new ResponseEntity<>(autoreAggiornato, HttpStatus.OK);
        }
    }

    //ok
    @DeleteMapping("/{id}")
    public String deleteAutoreById(@PathVariable int id) {
        autoreService.deleteAutoreById(id);
        return "Autore con id " + id + " eliminato con successo";
    }
}
