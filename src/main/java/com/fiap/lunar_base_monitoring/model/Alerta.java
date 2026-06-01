package com.fiap.lunar_base_monitoring.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String severidade;
    private LocalDateTime dataHora = LocalDateTime.now();
    private boolean resolvido = false;
}