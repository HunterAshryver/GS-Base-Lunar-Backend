package com.fiap.lunar_base_monitoring.controller;

import com.fiap.lunar_base_monitoring.model.Alerta;
import com.fiap.lunar_base_monitoring.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin(origins = "*")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @GetMapping
    public List<Alerta> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        Optional<Alerta> alerta = service.buscarPorId(id);
        return alerta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alerta> criar(@RequestBody Alerta alerta) {
        Alerta salvo = service.salvar(alerta);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizar(@PathVariable Long id, @RequestBody Alerta alerta) {
        Alerta atualizado = service.atualizar(id, alerta);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}