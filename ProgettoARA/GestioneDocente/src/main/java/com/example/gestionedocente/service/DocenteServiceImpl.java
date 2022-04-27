package com.example.gestionedocente.service;


import com.example.gestionedocente.converter.DocenteMapper;
import com.example.gestionedocente.data.dto.DocenteDto;
import com.example.gestionedocente.data.entity.Docente;
import com.example.gestionedocente.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    DocenteRepository docenteRepository;

    @Autowired
    DocenteMapper docenteMapper;

    @Override
    public DocenteDto findById(Long id) {
        return docenteMapper.toDto(docenteRepository.findById(id).get());
    }

    @Override
    public List<DocenteDto> findAll() {
        List<Docente> docenti = docenteRepository.findAll();
        List<DocenteDto> docenti_dto = new ArrayList<>();

        for(Docente docente : docenti){
            docenti_dto.add(docenteMapper.toDto(docente));
        }
        return docenti_dto;
    }

    @Override
    public String getNomeById(Long id){
        Docente docente = docenteRepository.findById(id).get();
        return docente.getNome() + " " + docente.getCognome();
    }

    @Override
    public String delete(Long id) {
        try{
            Docente docente = docenteRepository.findById(id).get();
            docenteRepository.delete(docente);
            return "Docente eliminato correttamente";
        }catch (Exception e){
            return e.getMessage().toString();
        }
    }

    @Override
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }
}
