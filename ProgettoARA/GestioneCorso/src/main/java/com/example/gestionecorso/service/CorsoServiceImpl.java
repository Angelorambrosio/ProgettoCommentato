package com.example.gestionecorso.service;

import com.example.gestionecorso.client.DocenteClient;
import com.example.gestionecorso.converter.CorsoMapper;
import com.example.gestionecorso.data.dto.CorsoDTO;
import com.example.gestionecorso.data.entity.Corso;
import com.example.gestionecorso.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CorsoServiceImpl implements CorsoService{

    @Autowired
    CorsoRepository corsoRepository;

    @Autowired
    CorsoMapper corsoMapper;

    @Autowired
    DocenteClient docenteClient;



    @Override
    public List<CorsoDTO> findAll() {

        List<Corso> corsi = corsoRepository.findAll();
        List<CorsoDTO> corsi_convertiti = new ArrayList<>();


        /*Per ogni elemento corso di tipo Corso preso dalla List corsi.*/
        for(Corso corso : corsi){
            corsi_convertiti.add(corsoMapper.toDto(corso));
        }

        return corsi_convertiti;
    }

    @Override
    public CorsoDTO findById(Long id) {
        return corsoMapper.toDto(corsoRepository.findById(id).get());
    }

    @Override
    public String delete(Long id) {
        //Controllo del docente
        try{
            Corso corso = corsoRepository.findById(id).get();



            /*Perche' si usa this??
            Non si puo' mettere direttamente
             if(checkDeleteDocente(corso.getId_docente())){
                ??
             */


            /*Se il docente ha solo questo corso, eliminiamo anche il docente.*/
            if(this.checkDeleteDocente(corso.getId_docente())){
                docenteClient.eliminaDocente(corso.getId_docente());
            }
            corsoRepository.delete(corso);
            return "Corso eliminato.";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public CorsoDTO getCorsoByNome(String nome) {
        try{
            return corsoMapper.toDto(corsoRepository.findByNome(nome));
        }catch (Exception e){
            return new CorsoDTO();
        }
    }

    @Override
    public String save(Corso corso) {

        /*Si usa "NoDoc" perche in GestioneDocente nel caso non trovi il docente
        * abbiamo impostato restituisca quello*/
        if(docenteClient.getNomeDocenteById(corso.getId_docente()).equals("NoDoc")){
            return "Non esiste il docente.";}
        else {
            corsoRepository.save(corso);
            return "Corso salvato correttamente.";
        }
    }

    @Override
    public Boolean checkDeleteDocente(Long id_docente) {
        List<Corso> corsi = corsoRepository.findCorsoById_docente(id_docente);
        if(corsi.size() <= 1){
            return true;}
        else {
            return false;}
        }
}
