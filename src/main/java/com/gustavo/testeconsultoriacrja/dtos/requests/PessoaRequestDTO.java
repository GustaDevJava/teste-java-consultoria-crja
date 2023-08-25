package com.gustavo.testeconsultoriacrja.dtos.requests;

import java.io.Serializable;
import java.util.Date;

public class PessoaRequestDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nome;
    private Date prazo;

    public PessoaRequestDTO(){}

    public PessoaRequestDTO(String nome, Date prazo) {
        this.nome = nome;
        this.prazo = prazo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
    
    
}
