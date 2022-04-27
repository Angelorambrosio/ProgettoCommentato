package com.example.gestionecorso.service;

import com.example.gestionecorso.data.dto.CorsoDTO;
import com.example.gestionecorso.data.entity.Corso;

import java.util.List;

public interface CorsoService {

    List<CorsoDTO> findAll();


    CorsoDTO findById(Long id);

    String delete(Long id);

    CorsoDTO getCorsoByNome(String nome);

    String save(Corso corso);

    Boolean checkDeleteDocente(Long id_docente);


}
