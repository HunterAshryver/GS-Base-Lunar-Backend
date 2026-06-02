package com.fiap.lunar_base_monitoring.controller;

import com.fiap.lunar_base_monitoring.model.ConsumoEnergia;
import com.fiap.lunar_base_monitoring.service.ConsumoEnergiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumo-energia")
@CrossOrigin(origins = "*")
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaService service;

    @GetMapping
    public List<ConsumoEnergia> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> buscarPorId(@PathVariable Long id) {
        Optional<ConsumoEnergia> consumo = service.buscarPorId(id);
        return consumo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConsumoEnergia> criar(@RequestBody ConsumoEnergia consumoEnergia) {
        ConsumoEnergia salvo = service.salvar(consumoEnergia);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> atualizar(@PathVariable Long id, @RequestBody ConsumoEnergia consumoEnergia) {
        ConsumoEnergia atualizado = service.atualizar(id, consumoEnergia);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}