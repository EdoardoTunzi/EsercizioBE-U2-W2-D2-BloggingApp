package com.example.EsercizioBE_U2_W2_D2_BloggingApp.service;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.PostDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.repository.AutoreDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //esempio di get con paginazione
    public Page<Autore> getAutori(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sort));
        return autoreRepo.findAll(pageable);
    }

    public Optional<Autore> getAutoreById(long id) {
        return autoreRepo.findById(id);
    }


    public Long addAutore(Autore autore) {
        Autore autoreInserito = autoreRepo.save(autore);
        return autoreInserito.getId();
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
