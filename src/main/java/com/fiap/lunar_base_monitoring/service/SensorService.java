package com.fiap.lunar_base_monitoring.service;

import com.fiap.lunar_base_monitoring.model.Sensor;
import com.fiap.lunar_base_monitoring.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repository;

    public List<Sensor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Sensor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Sensor salvar(Sensor sensor) {
        return repository.save(sensor);
    }

    public Sensor atualizar(Long id, Sensor sensorAtualizado) {
        sensorAtualizado.setId(id);
        return repository.save(sensorAtualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}