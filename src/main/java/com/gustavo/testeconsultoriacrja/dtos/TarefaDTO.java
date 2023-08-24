package com.gustavo.testeconsultoriacrja.dtos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gustavo.testeconsultoriacrja.models.Tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TarefaDTO implements Comparable<TarefaDTO>, Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = "O campo título é requerido")
    private String titulo;

    @NotBlank(message = "O campo título é requerido")
    private String descricao;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date prazo;

    @NotNull(message = "O campo departamento é requerido")
    private Integer departamento;

    @NotNull(message = "O campo duração é requerido")
    private int duracao;

    private Integer pessoa;
    private boolean finalizado;

    public TarefaDTO(){}

    public TarefaDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.prazo = tarefa.getPrazo();
        this.departamento = tarefa.getDepartamento().getId();
        this.duracao = tarefa.getDuracao();
        this.pessoa = (tarefa.getPessoa() != null) ? tarefa.getPessoa().getId() : null;
        this.finalizado = tarefa.isFinalizado();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Integer getPessoa() {
        return pessoa;
    }

    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public int compareTo(TarefaDTO dto) {
        return this.prazo.compareTo(dto.prazo);
    }
    
    
}
