package com.gustavo.testeconsultoriacrja.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.testeconsultoriacrja.dtos.TarefaDTO;
import com.gustavo.testeconsultoriacrja.models.Tarefa;
import com.gustavo.testeconsultoriacrja.services.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class TarefaController {
    
    @Autowired
    private TarefaService service;

    @PostMapping(value = "/tarefas")
    public ResponseEntity<TarefaDTO> create(@Valid @RequestBody TarefaDTO tarefaDTO){
        Tarefa novaTarefa = service.create(tarefaDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
        path("/{id}").buildAndExpand(novaTarefa.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "tarefas/alocar/{id}")
    public ResponseEntity<Tarefa> alocarPessoa(@RequestBody TarefaDTO dto, @PathVariable Integer id){
        Tarefa tarefa = service.addPessoa(id, dto);

        return ResponseEntity.ok().body(tarefa);
    }

    @PutMapping(value = "tarefas/finalizar/{id}")
    public ResponseEntity<Tarefa> finalizaTarefa(@PathVariable Integer id){
        Tarefa tarefa = service.finalizarTarefa(id);

        return ResponseEntity.ok().body(tarefa);
    } 

    @GetMapping(value = "tarefas/pendentes")
    public ResponseEntity<List<TarefaDTO>> buscarTarefaSemPessoa(){
        List<TarefaDTO> listaTarefas = service.tarefasSemPessoa();

        return ResponseEntity.ok().body(listaTarefas);
    }
}
