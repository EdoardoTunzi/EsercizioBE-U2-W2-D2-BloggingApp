package com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import lombok.Data;

@Data
public class PostDTO {
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private Autore autore;
}
