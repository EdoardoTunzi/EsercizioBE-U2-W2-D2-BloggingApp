package com.example.EsercizioBE_U2_W2_D2_BloggingApp.service;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.AutoreDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto.PostDTO;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
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


    public Long addAutore(AutoreDTO autoreDTO) {
        Autore autoreInserito = fromAutoreDTOToEntity(autoreDTO);
        Autore autoredaSalvare = autoreRepo.save(autoreInserito);
        return autoredaSalvare.getId();
    }

    public Autore addAutore2(Autore autore) {
        return autoreRepo.save(autore);
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

    //metodi travaso DTO
    public Autore fromAutoreDTOToEntity(AutoreDTO autoreDTO) {
        Autore autore = new Autore();
        autore.setNome(autoreDTO.getNome());
        autore.setCognome(autoreDTO.getCognome());
        autore.setEmail(autoreDTO.getEmail());
        autore.setDataDiNascita(autoreDTO.getDataDiNascita());
        autore.setAvatar(autoreDTO.getAvatar());
        return autore;
    }

    public AutoreDTO fromAutoreToAutoreDTO(Autore autore) {
        AutoreDTO autoreDTO = new AutoreDTO();
        autoreDTO.setNome(autore.getNome());
        autoreDTO.setCognome(autore.getCognome());
        autoreDTO.setEmail(autore.getEmail());
        autoreDTO.setDataDiNascita(autore.getDataDiNascita());
        autoreDTO.setAvatar(autore.getAvatar());
        return autoreDTO;
    }
}
