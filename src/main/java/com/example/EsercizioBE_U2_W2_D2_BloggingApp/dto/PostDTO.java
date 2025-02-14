package com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto;

import com.example.EsercizioBE_U2_W2_D2_BloggingApp.model.Autore;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PostDTO {
    @NotNull
    @Size(min = 3, max=50, message = "Il titolo deve avere un minimo di 3 caratteri fino ad un massimo di 50")
    private String titolo;

    @NotNull(message = "La categoria del post è obbligatoria")
    private String categoria;
    private String cover;

    @NotNull(message = "Il contenuto del post è obbligatorio")
    @NotBlank(message = "Il contenuto risulta vuoto")
    private String contenuto;

    @Positive(message = "La durata deve essere di almeno un minuto")
    @Max(value = 15, message="La durata supera gli standard del blog (15min)")
    private int tempoLettura;

    @NotNull(message = "Specificare l'autore del post")
    private Long fk_autore;
}
