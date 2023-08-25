package com.gustavo.testeconsultoriacrja.dtos;

import java.io.Serializable;

import com.gustavo.testeconsultoriacrja.models.Departamento;

public class DepartamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public DepartamentoDTO(){}

    public DepartamentoDTO(Departamento departamento) {
        this.id = departamento.getId();
        this.nome = departamento.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    
}
