package com.example.EsercizioBE_U2_W2_D2_BloggingApp.model;


import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;


public class BlogPost {
    private int id;
    private String categoria;
    private String titolo;
    private String cover = null;
    private String contenuto;
    private int tempoDiLettura;
    private static int count = 1;

    public BlogPost(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.id = count++;
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
