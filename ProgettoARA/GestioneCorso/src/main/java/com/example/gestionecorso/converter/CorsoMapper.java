package com.example.gestionecorso.converter;

import com.example.gestionecorso.client.DocenteClient;
import com.example.gestionecorso.data.dto.CorsoDTO;
import com.example.gestionecorso.data.entity.Corso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/*@Configuration crea un bean a partire da questa classe.
  La classe mapper serve a convertire da entity a dto.*/
@Configuration
public class CorsoMapper {

    @Autowired
    DocenteClient docenteClient;

    public CorsoDTO toDto(Corso corso){

        CorsoDTO corsoConvertito = new CorsoDTO();

        corsoConvertito.setNome(corso.getNome());
        corsoConvertito.setDurata(corso.getDurata());
        corsoConvertito.setData_inizio(corso.getData_inizio());

        /*Non possiamo accedere al nome del docente dal corso quindi
        * utilizziamo il metodo getNomeDocenteById dichiarato nel DocenteClient. */
        corsoConvertito.setNome_docente(docenteClient.getNomeDocenteById(corso.getId_docente()));

        return corsoConvertito;

    }


}
