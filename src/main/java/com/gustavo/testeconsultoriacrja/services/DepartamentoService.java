package com.gustavo.testeconsultoriacrja.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.testeconsultoriacrja.dtos.DepartamentoDTO;
import com.gustavo.testeconsultoriacrja.models.Departamento;
import com.gustavo.testeconsultoriacrja.models.Pessoa;
import com.gustavo.testeconsultoriacrja.models.Tarefa;
import com.gustavo.testeconsultoriacrja.repositories.DepartamentoRepository;
import com.gustavo.testeconsultoriacrja.repositories.PessoaRepository;
import com.gustavo.testeconsultoriacrja.repositories.TarefaRepository;

@Service
public class DepartamentoService {
    
    @Autowired
    private DepartamentoRepository repository;

    @Autowired
    public TarefaRepository tarefaRepository;

    @Autowired
    public PessoaRepository pessoaRepository;

    public Departamento create(Departamento departamento){
        return repository.save(departamento);
    }

    public List<Departamento> listarDepartamento() {
        return null;
    }

    public Departamento findById(Integer id) {
        Optional<Departamento> depOptional = repository.findById(id);
        return depOptional.get();
    }

    public List<DepartamentoDTO> findAllTotal(){
        List<Departamento> listDepartamentos = repository.findAll();
        List<Tarefa> listTarefas = tarefaRepository.findAll();
        List<Pessoa> listPessoas = pessoaRepository.findAll();
        List<DepartamentoDTO> departamentoTotal = new ArrayList<>();
        
        int totalPessoas = 0;
        int totalTarefas = 0;

        

        for(int d = 0; d < listDepartamentos.size(); d++){
        
            for(int i = 0; i < listPessoas.size(); i++){
                if(listPessoas.get(i).getDepartamento().getId() == listDepartamentos.get(d).getId()){
                    totalPessoas++;
                }
            }

            for(int i = 0; i < listTarefas.size(); i++){
                if(listTarefas.get(i).getDepartamento().getId() == listDepartamentos.get(d).getId()){
                    totalTarefas++;
                }
            }
        
                DepartamentoDTO departamentoDTO = new DepartamentoDTO();
                departamentoDTO.setNome(listDepartamentos.get(d).getNome());
                departamentoDTO.setQuantidadePessoas(totalPessoas);
                departamentoDTO.setQuantidadeTarefa(totalTarefas);
                departamentoTotal.add(departamentoDTO);

                totalPessoas = 0;
                totalTarefas = 0;
        }

        return departamentoTotal;
    }
    
}
