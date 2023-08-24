package com.gustavo.testeconsultoriacrja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.testeconsultoriacrja.models.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{
    
}
