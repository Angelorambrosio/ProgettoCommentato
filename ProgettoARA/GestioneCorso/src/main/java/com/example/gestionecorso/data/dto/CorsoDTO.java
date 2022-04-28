package com.example.gestionecorso.data.dto;

import lombok.Data;

import java.time.LocalDate;

/*In questa classe specifichiamo gli attributi che vogliamo far visualizzare
* all'utente ( al client chiamante è la definizione più corretta, perché il chiamante potrebbe essere un 
  altro microservizio o un front end , non per forza direttamente l'utente.*/
@Data
public class CorsoDTO {

    private String nome;
    private Long durata;
    private LocalDate data_inizio;
    private String nome_docente;
}
