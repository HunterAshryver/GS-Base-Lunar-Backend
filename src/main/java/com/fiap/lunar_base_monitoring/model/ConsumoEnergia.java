package com.fiap.lunar_base_monitoring.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumo_energia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ConsumoEnergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double consumoKwh;
    private LocalDateTime dataHora = LocalDateTime.now();
    private String setor;
}