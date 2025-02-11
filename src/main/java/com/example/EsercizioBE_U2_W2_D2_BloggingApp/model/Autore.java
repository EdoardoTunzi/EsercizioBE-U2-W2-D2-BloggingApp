package com.example.EsercizioBE_U2_W2_D2_BloggingApp.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class Autore {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar = null;
    private static int count = 0;

    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.id = ++count;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
