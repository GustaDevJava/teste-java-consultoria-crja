package com.gustavo.testeconsultoriacrja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.testeconsultoriacrja.models.Departamento;
import com.gustavo.testeconsultoriacrja.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
    
    @Autowired
    private DepartamentoRepository repository;

    public Departamento create(Departamento departamento){
        return repository.save(departamento);
    }

    public List<Departamento> listarDepartamento() {
        return null;
    }

    
}
