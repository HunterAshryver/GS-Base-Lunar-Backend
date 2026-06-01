package com.fiap.lunar_base_monitoring.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "climatizacao")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Climatizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;
    private Double umidade;
    private String status;
    private LocalDateTime ultimaAtualizacao = LocalDateTime.now();
}