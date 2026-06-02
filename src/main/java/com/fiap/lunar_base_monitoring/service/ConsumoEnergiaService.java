package com.fiap.lunar_base_monitoring.service;

import com.fiap.lunar_base_monitoring.model.ConsumoEnergia;
import com.fiap.lunar_base_monitoring.repository.ConsumoEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoEnergiaService {

    @Autowired
    private ConsumoEnergiaRepository repository;

    public List<ConsumoEnergia> listarTodos() {
        return repository.findAll();
    }

    public Optional<ConsumoEnergia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ConsumoEnergia salvar(ConsumoEnergia consumoEnergia) {
        return repository.save(consumoEnergia);
    }

    public ConsumoEnergia atualizar(Long id, ConsumoEnergia consumoAtualizado) {
        consumoAtualizado.setId(id);
        return repository.save(consumoAtualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}