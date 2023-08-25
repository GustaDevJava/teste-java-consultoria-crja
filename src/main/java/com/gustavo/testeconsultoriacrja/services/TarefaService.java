package com.gustavo.testeconsultoriacrja.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.testeconsultoriacrja.dtos.TarefaDTO;
import com.gustavo.testeconsultoriacrja.exceptions.ObjectNotFoundException;
import com.gustavo.testeconsultoriacrja.models.Departamento;
import com.gustavo.testeconsultoriacrja.models.Pessoa;
import com.gustavo.testeconsultoriacrja.models.Tarefa;
import com.gustavo.testeconsultoriacrja.repositories.DepartamentoRepository;
import com.gustavo.testeconsultoriacrja.repositories.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Tarefa create(TarefaDTO tarDTO) {
        Tarefa tarefa = populaTarefa(tarDTO);
        return repository.save(tarefa);
    }

    public Tarefa addPessoa(Integer id, TarefaDTO tarefaDTO) {

        Pessoa pessoaAdd = pessoaService.findById(tarefaDTO.getPessoa());
        Optional<Tarefa> tarefaCreated = repository.findById(id);

        if (pessoaAdd.getDepartamento() == tarefaCreated.get().getDepartamento()) {
            tarefaCreated.get().setPessoa(pessoaAdd);
        } else {
            throw new ObjectNotFoundException("Pessoa não perterce a esse departemento");
        }

        return repository.save(tarefaCreated.get());
    }

    public Tarefa finalizarTarefa(Integer id) {
        Optional<Tarefa> tarefa = repository.findById(id);
        tarefa.get().setFinalizado(true);
        return tarefa.get();
    }

    public List<TarefaDTO> tarefasSemPessoa() {
        List<Tarefa> tarefasCriadas = repository.findAll();

        List<TarefaDTO> tarefasSemPessoa = new ArrayList<>();

        if (!tarefasCriadas.isEmpty()) {
            for (int i = 0; i < tarefasCriadas.size(); i++) {

                if (tarefasCriadas.get(i).getPessoa() == null) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setId(tarefasCriadas.get(i).getId());
                    tarefa.setTitulo(tarefasCriadas.get(i).getTitulo());
                    tarefa.setDescricao(tarefasCriadas.get(i).getDescricao());
                    tarefa.setPrazo(tarefasCriadas.get(i).getPrazo());
                    tarefa.setDepartamento(tarefasCriadas.get(i).getDepartamento());
                    tarefa.setDuracao(tarefasCriadas.get(i).getDuracao());
                    tarefa.setFinalizado(tarefasCriadas.get(i).isFinalizado());
                    tarefasSemPessoa.add(new TarefaDTO(tarefa));
                    if (tarefasSemPessoa.size() >= 3) {
                        break;
                    }
                }
            }
        }

        Collections.sort(tarefasSemPessoa, Comparator.comparing(TarefaDTO::getPrazo));
        return tarefasSemPessoa;
    }

    public List<Tarefa> buscarTodasTarefas(){
        return repository.findAll();
    }

    private Tarefa populaTarefa(TarefaDTO dto) {
        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrazo(dto.getPrazo());

        Optional<Departamento> departamento = departamentoRepository.findById(dto.getDepartamento());
        tarefa.setDepartamento(departamento.get());
        tarefa.setDuracao(dto.getDuracao());
        if (dto.getPessoa() != null) {
            Pessoa pessoa = pessoaService.findById(dto.getPessoa());
            tarefa.setPessoa(pessoa);
        }

        tarefa.setFinalizado(dto.isFinalizado());

        return tarefa;
    }
}
