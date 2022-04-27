package com.example.gestionedocente.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "docente")

public class Docente {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "nome")
    private String nome;

}
