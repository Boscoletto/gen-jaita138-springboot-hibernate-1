package org.generation.jaita138.pip.database.repo;

import java.util.List;
import org.generation.jaita138.pip.database.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long>{
    List<Utente> findByNomeStartingWith(String start);
    List<Utente> findByCreditoGreaterThan(int great);
    List<Utente> findByNomeNullOrCognomeNull();
    List<Utente> findByCreditoBetween(int start, int end);
}