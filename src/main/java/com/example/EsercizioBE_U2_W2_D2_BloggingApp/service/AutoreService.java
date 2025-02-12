package com.example.EsercizioBE_U2_W2_D2_BloggingApp.service;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.PostDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.repository.AutoreDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    AutoreDAORepository autoreRepo;
    public List<Autore> getAllAutori() {
        return autoreRepo.findAll();
    }

    public Optional<Autore> getAutoreById(long id) {
        Optional<Autore> autore = autoreRepo.findById(id);
        if(autore.isPresent()) {
            return autore;
        } else {
            throw new RuntimeException("Autore non trovato nel DB");
        }
    }


    public String addAutore(Autore autore) {
        autoreRepo.save(autore);
        return "Autore con id: " + autore.getId() + "salvato nel db";
    }

    /*public Autore updateAutoreById(long id, Autore autore) {
        Autore result = getAutoreById(id).get();
        result.setAutore(post.getAutore());
        result.setTitolo(post.getTitolo());
        result.setCategoria(post.getCategoria());
        result.setContenuto(post.getContenuto());
        result.setTempoDiLettura(post.getTempoDiLettura());
        return result;
    }*/

    public void deleteAutoreById(long id) {
        Optional<Autore> result = getAutoreById(id);
        if (result.isPresent()) {
            autoreRepo.deleteById(id);
        } else {
            throw new RuntimeException("Nessun utente con questo id da poter eliminare");
        }

    }
}
