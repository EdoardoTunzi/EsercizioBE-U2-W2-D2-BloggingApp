package com.example.EsercizioBE_U2_W2_D2_BloggingApp.controller;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    /*@GetMapping("/")
    public List<Post> getAllPost() {
       *//* return blogPosts;*//*
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        *//*return blogPosts.stream()
                .filter(post -> post.getId() == id)
                .findFirst().get();*//*
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String newPost(@RequestBody Post post) {
        *//*String descrizione = "Dettaglio post: \n";
        descrizione += "Id: " + post.getId() + "\n";
        descrizione += "categoria: " + post.getCategoria() + "\n";
        descrizione += "titolo: " + post.getTitolo() + "\n";
        descrizione += "contenuto: " +post.getContenuto() + "\n";
        descrizione += "tempo di lettura" + post.getTempoDiLettura() + "\n";
        blogPosts.add(new Post(post.getCategoria(),post.getTitolo(),post.getContenuto(),post.getTempoDiLettura()));
        return descrizione;*//*
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@PathVariable int id, @RequestBody Post post) {
       *//* Post postModificare = blogPosts.stream()
                .filter(blogpost -> blogpost.getId() == id)
                .findFirst().get();

        if (postModificare != null) {
            postModificare.setTitolo(post.getTitolo());
            postModificare.setCategoria(post.getCategoria());
            postModificare.setContenuto(post.getContenuto());
            postModificare.setTempoDiLettura(post.getTempoDiLettura());
        }
        return postModificare;*//*
    }

    @DeleteMapping("/{id}")
    public String updatePost(@PathVariable int id) {
       *//* Post postModificare = blogPosts.stream()
                .filter(blogpost -> blogpost.getId() == id)
                .findFirst().get();
        blogPosts.remove(postModificare);
        return "Post cancellato";*//*
    }*/
}
