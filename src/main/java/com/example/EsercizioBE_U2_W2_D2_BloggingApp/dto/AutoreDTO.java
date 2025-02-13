package com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDTO {
    @NotB
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
}
