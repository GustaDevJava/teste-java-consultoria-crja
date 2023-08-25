package com.gustavo.testeconsultoriacrja.dtos;

import java.io.Serializable;

import com.gustavo.testeconsultoriacrja.models.Departamento;

public class DepartamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int quantidadePessoas;
    private int quantidadeTarefa;

    public DepartamentoDTO(){}

    public DepartamentoDTO(Departamento departamento, int quantidadePessoas, int quantidadeTarefa) {
        this.nome = departamento.getNome();
        this.quantidadePessoas = quantidadePessoas;
        this.quantidadeTarefa = quantidadeTarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public int getQuantidadeTarefa() {
        return quantidadeTarefa;
    }

    public void setQuantidadeTarefa(int quantidadeTarefa) {
        this.quantidadeTarefa = quantidadeTarefa;
    }

    

    
}
