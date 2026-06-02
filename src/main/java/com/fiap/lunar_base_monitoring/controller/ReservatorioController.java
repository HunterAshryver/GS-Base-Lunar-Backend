package com.fiap.lunar_base_monitoring.controller;

import com.fiap.lunar_base_monitoring.model.Reservatorio;
import com.fiap.lunar_base_monitoring.service.ReservatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservatorios")
@CrossOrigin(origins = "*")
public class ReservatorioController {

    @Autowired
    private ReservatorioService service;

    @GetMapping
    public List<Reservatorio> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservatorio> buscarPorId(@PathVariable Long id) {
        Optional<Reservatorio> reservatorio = service.buscarPorId(id);
        return reservatorio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reservatorio> criar(@RequestBody Reservatorio reservatorio) {
        Reservatorio salvo = service.salvar(reservatorio);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservatorio> atualizar(@PathVariable Long id, @RequestBody Reservatorio reservatorio) {
        Reservatorio atualizado = service.atualizar(id, reservatorio);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}