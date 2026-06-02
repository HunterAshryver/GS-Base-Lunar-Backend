package com.fiap.lunar_base_monitoring.service;

import com.fiap.lunar_base_monitoring.model.Climatizacao;
import com.fiap.lunar_base_monitoring.repository.ClimatizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClimatizacaoService {

    @Autowired
    private ClimatizacaoRepository repository;

    public List<Climatizacao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Climatizacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Climatizacao salvar(Climatizacao climatizacao) {
        return repository.save(climatizacao);
    }

    public Climatizacao atualizar(Long id, Climatizacao climatizacaoAtualizado) {
        climatizacaoAtualizado.setId(id);
        return repository.save(climatizacaoAtualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}