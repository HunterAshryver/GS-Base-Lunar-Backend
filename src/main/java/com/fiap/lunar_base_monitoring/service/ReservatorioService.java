package com.fiap.lunar_base_monitoring.service;

import com.fiap.lunar_base_monitoring.model.Reservatorio;
import com.fiap.lunar_base_monitoring.repository.ReservatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservatorioService {

    @Autowired
    private ReservatorioRepository repository;

    public List<Reservatorio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Reservatorio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Reservatorio salvar(Reservatorio reservatorio) {
        return repository.save(reservatorio);
    }

    public Reservatorio atualizar(Long id, Reservatorio reservatorioAtualizado) {
        reservatorioAtualizado.setId(id);
        return repository.save(reservatorioAtualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}