package com.fabrica.CheckIn.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TarjetaEmbarque {

    @Id
    @GeneratedValue
    private Long idTarjetaEmbargue;

    private String nombreCompleto;

    @Column(length = 512)
    private String qrUnico;
}
