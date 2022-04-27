package com.example.gestionecorso.repository;

import com.example.gestionecorso.data.entity.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/*Lo strato repository e' quello che si interfaccia con il DB tramite SpringDataJPA*/

public interface CorsoRepository extends JpaRepository<Corso, Long> {


    /*La query prende la variabile :id_docente e restituisce le righe all'interno
     della List<Corso>.Serve a trovare i corsi di un docente.
      Effettuiamo quest'operazione perche' le classi Corso e Docente si trovano su
      due microservizi diversi e quindi non possiamo specificarli direttamente alla
       creazione delle tabelle nelle classi.*/

    @Query(value="SELECT C FROM Corso C WHERE C.id_docente = :id_docente")
    List<Corso> findCorsoById_docente(@Param("id_docente")Long id_docente);

    Corso findByNome(String nome_corso);

}
