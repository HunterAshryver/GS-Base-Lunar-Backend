package com.fiap.lunar_base_monitoring.controller;

import com.fiap.lunar_base_monitoring.model.Climatizacao;
import com.fiap.lunar_base_monitoring.service.ClimatizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/climatizacao")
@CrossOrigin(origins = "*")
public class ClimatizacaoController {

    @Autowired
    private ClimatizacaoService service;

    @GetMapping
    public List<Climatizacao> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Climatizacao> buscarPorId(@PathVariable Long id) {
        Optional<Climatizacao> climatizacao = service.buscarPorId(id);
        return climatizacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Climatizacao> criar(@RequestBody Climatizacao climatizacao) {
        Climatizacao salvo = service.salvar(climatizacao);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Climatizacao> atualizar(@PathVariable Long id, @RequestBody Climatizacao climatizacao) {
        Climatizacao atualizado = service.atualizar(id, climatizacao);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}