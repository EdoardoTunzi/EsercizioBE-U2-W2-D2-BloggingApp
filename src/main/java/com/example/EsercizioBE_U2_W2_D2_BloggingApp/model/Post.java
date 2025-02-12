package com.example.EsercizioBE_U2_W2_D2_BloggingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoria;
    private String titolo;
    private String cover = null;
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    private Autore autore;

    public Post(String categoria, String titolo, String contenuto, int tempoDiLettura) {

        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

}
