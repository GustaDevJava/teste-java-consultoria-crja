package com.gustavo.testeconsultoriacrja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.testeconsultoriacrja.models.Tarefa;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Integer>{
    
}
