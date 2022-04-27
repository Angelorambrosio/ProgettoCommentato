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
    @PostMapping(value = "/modificaCorso")
    public void modificaCorso(@RequestBody Corso corso){corsoService.save(corso);}

    @GetMapping(value = "/ricerca/nome/{nome_corso}")
    public CorsoDTO getCorsoByNome(@PathVariable("nome_corso")String nome_corso){
        return corsoService.getCorsoByNome(nome_corso);
    }
}
