package com.example.gestionecorso.rest;


import com.example.gestionecorso.data.dto.CorsoDTO;
import com.example.gestionecorso.data.entity.Corso;
import com.example.gestionecorso.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corso")
public class RestCorsoController {

    @Autowired
    CorsoService corsoService;

    @GetMapping(value = "/ricerca/id/{id}")
    public CorsoDTO getById(@PathVariable("id")Long id){return corsoService.findById(id);}

    @GetMapping(value = "/lista" )
    public List<CorsoDTO> getAll(){return corsoService.findAll();}

    @PostMapping(value = "/newCorso")
    public String newCorso(@RequestBody Corso corso){return corsoService.save(corso);}

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCorsoById(@PathVariable("id")Long id){corsoService.delete(id);}


    /*Non dovremmo controllare se il corso esiste prima di modificarlo?*/
    /* ANTONIO
        Teoricamente si sarebbe piu corretto.
        Anzi in realtà sarebbe più corretto fare in questo modo: 
        se guardi la riga 26 e la riga 40 praticamente stiamo definendo due end-point 
        che fanno esattamente la stessa cosa ossiamo corsoService.save(corso);
        sarebbe più corretto creare un solo end-point magari con il nome SalvaCorso
        e utilizzare quella funzione. Hibernate e soprattutto la libreria JPARepository
        riesce ad identificare se è un nuovo Corso ( in questo caso ) oppure se è uno da
        aggiornare. Praticamente se gli passi un nuovo corso con id: 0 , lui lo aggiungerà 
        alla tabella, oppure se gli passi un id che non esiste sulla tabella Corso nel database
        lui farà un nuovo inserimento. Se gli passi un Corso con un id presente sul database
        lui provvederà ad aggiornare quello già presente
    */
    
    @PostMapping(value = "/modificaCorso")
    public void modificaCorso(@RequestBody Corso corso){corsoService.save(corso);}

    @GetMapping(value = "/ricerca/nome/{nome_corso}")
    public CorsoDTO getCorsoByNome(@PathVariable("nome_corso")String nome_corso){
        return corsoService.getCorsoByNome(nome_corso);
    }
}
