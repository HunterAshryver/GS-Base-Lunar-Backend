package com.fiap.lunar_base_monitoring.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensores")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String localizacao;
    private Double valorAtual;
    private LocalDateTime ultimaLeitura = LocalDateTime.now();
    private String status;
}