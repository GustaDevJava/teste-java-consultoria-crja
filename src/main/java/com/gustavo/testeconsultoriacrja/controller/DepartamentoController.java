package com.gustavo.testeconsultoriacrja.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.testeconsultoriacrja.dtos.DepartamentoDTO;
import com.gustavo.testeconsultoriacrja.models.Departamento;
import com.gustavo.testeconsultoriacrja.services.DepartamentoService;

@RestController
@RequestMapping("/")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService service;

    @PostMapping(value = "departamentos")
    public ResponseEntity<Departamento> create(@RequestBody Departamento departamento){
        Departamento novoDepartamento = service.create(departamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
        path("/{id}").buildAndExpand(novoDepartamento.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "get/departamentos")
    public ResponseEntity<List<DepartamentoDTO>> listarDepartamento(){
        List<DepartamentoDTO> departamentosDtos = service.findAllTotal();

        return ResponseEntity.ok().body(departamentosDtos);
    }

    @GetMapping(value = "depatamento/{id}")
    public ResponseEntity<Departamento> findById(@PathVariable Integer id){
        Departamento departamento = service.findById(id);

        return ResponseEntity.ok().body(departamento);
    }
}
