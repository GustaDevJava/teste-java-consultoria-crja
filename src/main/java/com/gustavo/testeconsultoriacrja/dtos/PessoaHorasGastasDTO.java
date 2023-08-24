package com.gustavo.testeconsultoriacrja.dtos;

import java.io.Serializable;

import com.gustavo.testeconsultoriacrja.models.Pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaHorasGastasDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = "O campo nome é requerido")
    private String nome; 

    @NotNull(message = "O campo departamento é requerido")
    private Integer departamento;

    private String horasGastas;

    public PessoaHorasGastasDTO(){}

    public PessoaHorasGastasDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.departamento = pessoa.getDepartamento().getId();
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

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public String getHorasGastas() {
        return horasGastas;
    }

    public void setHorasGastas(String horasGastas) {
        this.horasGastas = horasGastas;
    }
    
}
