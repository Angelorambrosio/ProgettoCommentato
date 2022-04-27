package com.example.gestionedocente.repository;


import com.example.gestionedocente.data.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
