package com.fiap.lunar_base_monitoring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservatorios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private Double capacidadeMaxima;
    private Double nivelAtual;
    private String localizacao;
}