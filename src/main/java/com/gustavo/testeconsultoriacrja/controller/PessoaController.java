package com.gustavo.testeconsultoriacrja.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.testeconsultoriacrja.dtos.PessoaDTO;
import com.gustavo.testeconsultoriacrja.dtos.PessoaHorasGastasDTO;
import com.gustavo.testeconsultoriacrja.models.Pessoa;
import com.gustavo.testeconsultoriacrja.services.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class PessoaController {
    
    @Autowired
    private PessoaService service;

    @PostMapping(value = "post/pessoas")
    public ResponseEntity<Pessoa> create(@Valid @RequestBody PessoaDTO pessoaDTO){
        Pessoa novaPessoa = service.create(pessoaDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
        path("/{id}").buildAndExpand(novaPessoa.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "put/pessoas/{id}")
    public ResponseEntity<Pessoa> update(@RequestBody PessoaDTO pessoaDTO, @PathVariable Integer id){
        Pessoa updatePessoa = service.update(id, pessoaDTO);

        return ResponseEntity.ok().body(updatePessoa);
    }

    @DeleteMapping(value = "delete/pessoas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "get/pessoas")
    public ResponseEntity<List<PessoaHorasGastasDTO>> buscarPessoas(){
        List<PessoaHorasGastasDTO> buscPessoas = service.buscarPessoas();

        return ResponseEntity.ok().body(buscPessoas);
    }
}
