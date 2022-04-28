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
     
     /ANTONIO/ Questa cosa qui sotto è totalmente sbagliata e la frase non ha un senso logico
      Effettuiamo quest'operazione perche' le classi Corso e Docente si trovano su
      due microservizi diversi e quindi non possiamo specificarli direttamente alla
       creazione delle tabelle nelle classi.*/
    
    //ANTONIO/ La tabella Corso ha solamente l'id del docente, ciò è sufficiente
    // ad avere la lista dei Corsi associati ad esso.
    // Definiamo @Query perché aiutiamo hibernate a capire cosa effettivamente abbiamo bisogno,
    // Quindi gli scriviamo una query in simil-sql. Il fatto che la tabella docente sia su
    // un altra tabella non ci interessa. Nel service del corso utilizziamo questa funzione
    // per controllare il numero dei corsi del docente associato a quell'id e verificare
    // se all'eliminazione del corso , il docente non ha piu corsi assegnati ( quindi 
    // se ha 1 o meno corsi va eliminato ) , ma l'eliminazione viene fatta chiamando 
    // tramite il protocollo http l'api rest per eliminare il docente all'altro microservizio
    // utilizzando il feignclient per effettuare la richiesta
    
    @Query(value="SELECT C FROM Corso C WHERE C.id_docente = :id_docente")
    List<Corso> findCorsoById_docente(@Param("id_docente")Long id_docente);

    Corso findByNome(String nome_corso);

}
