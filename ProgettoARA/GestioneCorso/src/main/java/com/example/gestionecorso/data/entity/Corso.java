package com.example.gestionecorso.data.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/*Con @entity specifichiamo la creazione di una tabella sul db
 con il nome e gli attributi di questa classe.
 Con @Data creiamo automaticamente Getter Setter, non dichiariamo nessun costruttore o altri metodi, solo getter e setter.*/

@Entity
@Data
@Table(name = "corso")
public class Corso {

    /*@Column e' opzionale nel caso in cui vogliamo specificare
     un nome diverso o altre cose.(not null, tipo e lunghezza dato ecc)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;


    private LocalDate data_inizio;


    private Long durata;


    private Long id_docente;
}
