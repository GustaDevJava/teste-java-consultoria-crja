package com.gustavo.testeconsultoriacrja.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome; 

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Tarefa> listaTarefas = new ArrayList<>();
    
    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, Departamento departamento, List<Tarefa> listaTarefas) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.listaTarefas = listaTarefas;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }
    
}
