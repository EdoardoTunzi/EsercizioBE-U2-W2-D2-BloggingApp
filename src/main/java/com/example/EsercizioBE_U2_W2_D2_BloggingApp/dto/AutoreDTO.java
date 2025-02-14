package com.example.EsercizioBE_U2_W2_D2_BloggingApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
public class AutoreDTO {
    @NotBlank(message = "Il nome non deve essere lasciato vuoto")
    @NotNull(message = "Il nome è obbligatorio")
    private String nome;
    @NotBlank(message = "Il cognome non deve essere lasciato vuoto")
    @NotNull(message = "Il cognome è obbligatorio")
    private String cognome;
    @NotNull(message = "L'email è obbligatoria")
    @NotBlank(message = "L'email non deve essere lasciato vuoto")
    @Email(message = "L'email inserita non e un indirizzo valido")
    private String email;
    private LocalDate dataDiNascita;
    @URL
    private String avatar;
}
