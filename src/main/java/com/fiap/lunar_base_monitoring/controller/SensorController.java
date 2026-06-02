package com.fiap.lunar_base_monitoring.controller;

import com.fiap.lunar_base_monitoring.model.Sensor;
import com.fiap.lunar_base_monitoring.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensores")
@CrossOrigin(origins = "*")
public class SensorController {

    @Autowired
    private SensorService service;

    @GetMapping
    public List<Sensor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> buscarPorId(@PathVariable Long id) {
        Optional<Sensor> sensor = service.buscarPorId(id);
        return sensor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sensor> criar(@RequestBody Sensor sensor) {
        Sensor salvo = service.salvar(sensor);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> atualizar(@PathVariable Long id, @RequestBody Sensor sensor) {
        Sensor atualizado = service.atualizar(id, sensor);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}