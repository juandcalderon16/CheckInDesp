package com.fabrica.CheckIn.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TarjetaEmbargue {

    @Id
    @GeneratedValue
    private Long idTarjetaEmbargue;

    private String nombreCompleto;

    @Column(length = 512)
    private String qrUnico;
}
