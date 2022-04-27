package com.example.gestionecorso.data.dto;

import lombok.Data;

import java.time.LocalDate;

/*In questa classe specifichiamo gli attributi che vogliamo far visualizzare
* all'utente.*/
@Data
public class CorsoDTO {

    private String nome;
    private Long durata;
    private LocalDate data_inizio;
    private String nome_docente;
}
