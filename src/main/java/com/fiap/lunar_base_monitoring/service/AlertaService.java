package com.fiap.lunar_base_monitoring.service;

import com.fiap.lunar_base_monitoring.model.Alerta;
import com.fiap.lunar_base_monitoring.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository repository;

    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        return repository.save(alerta);
    }

    public Alerta atualizar(Long id, Alerta alertaAtualizado) {
        alertaAtualizado.setId(id);
        return repository.save(alertaAtualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}