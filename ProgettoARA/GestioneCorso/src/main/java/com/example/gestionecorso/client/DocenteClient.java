package com.example.gestionecorso.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*Va dichiarato nell'application.
Da qui con @FeignClient ci colleghiamo al microservizio GestioneDocente
specificando nome e url (in caso sia presente la sicurezza dovremmo
specificare anche le credenziali.
Con i @GetMapping invece specifichiamo i servizi a cui vogliamo accedere,
assegnandogli un nuovo nome e passandogli i parametri con @PathVariable
se necessario.*/

@FeignClient(name = "GestioneDocente", url = "http://localhost:8081")
public interface DocenteClient {

    @GetMapping(value = "/api/docente/getNomeById/{id}")
    String getNomeDocenteById(@PathVariable("id")Long id);

    @DeleteMapping(value = "/api/docente/{id}")
    String eliminaDocente(@PathVariable("id")Long id);
}
