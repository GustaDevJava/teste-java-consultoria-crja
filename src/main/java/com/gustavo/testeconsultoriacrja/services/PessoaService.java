package com.gustavo.testeconsultoriacrja.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.testeconsultoriacrja.dtos.PessoaDTO;
import com.gustavo.testeconsultoriacrja.dtos.PessoaHorasGastasDTO;
import com.gustavo.testeconsultoriacrja.exceptions.ObjectNotFoundException;
import com.gustavo.testeconsultoriacrja.models.Departamento;
import com.gustavo.testeconsultoriacrja.models.Pessoa;
import com.gustavo.testeconsultoriacrja.models.Tarefa;
import com.gustavo.testeconsultoriacrja.repositories.DepartamentoRepository;
import com.gustavo.testeconsultoriacrja.repositories.PessoaRepository;
import com.gustavo.testeconsultoriacrja.repositories.TarefaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;

    @Autowired 
    private TarefaRepository tarefaRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Pessoa create(PessoaDTO pessoaDTO){
        Pessoa pessoa = populaPessoa(pessoaDTO);
        return repository.save(pessoa);
    }

    public Pessoa update(Integer id, PessoaDTO pessoaDTO){
        Optional<Pessoa> pessoaOld = repository.findById(id);

        pessoaOld.get().setNome(pessoaDTO.getNome());

        if(pessoaDTO.getDepartamento() != null){
            Optional<Departamento> departamento = departamentoRepository.findById(pessoaDTO.getDepartamento());
            pessoaOld.get().setDepartamento(departamento.get());
        }
        
        
        return repository.save(pessoaOld.get());
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public Pessoa findById(Integer id) {
        try {
            Optional<Pessoa> pessoa = repository.findById(id);
            return pessoa.get();
        } catch (Exception e) {
            throw new ObjectNotFoundException("Pessoa não encontrado na base de dados!");
        }

    }
    

    private Pessoa populaPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(pessoaDTO.getNome());
        Optional<Departamento> departamento = departamentoRepository.findById(pessoaDTO.getDepartamento());
        pessoa.setDepartamento(departamento.get());

        return pessoa;
    }

    public List<PessoaHorasGastasDTO> buscarPessoas(){
        List<Pessoa> pessoas = repository.findAll();
        List<Tarefa> listaTarefas = tarefaRepository.findAll();
        List<PessoaHorasGastasDTO> pessoaComHorasGastas = new ArrayList<>();

        if (!pessoas.isEmpty()) {
            for (int i = 0; i < pessoas.size(); i++) {
                if (!listaTarefas.isEmpty()) {
                    for (int t = 0; t < listaTarefas.size(); t++) {
                            
                        if(listaTarefas.get(t).getPessoa() != null && pessoas.get(i).getId() == listaTarefas.get(t).getPessoa().getId()){
                            PessoaHorasGastasDTO pessoa = new PessoaHorasGastasDTO();
                            pessoa.setId(pessoas.get(i).getId());
                            pessoa.setNome(pessoas.get(i).getNome());
                            Optional<Departamento> departamento = departamentoRepository.findById(pessoas.get(i).getDepartamento().getId());
                            pessoa.setDepartamento(departamento.get().getId());
                            pessoa.setHorasGastas(pessoas.get(i).getNome() +" tem o total de "+listaTarefas.get(t).getDuracao() + " horas gastas na tarefa "+ listaTarefas.get(t).getId());
                            pessoaComHorasGastas.add(pessoa);
                        }
                    }
                }

            }
        }

        return pessoaComHorasGastas;
     
    }

}
