package com.fabrica.CheckIn.controller;

import com.fabrica.CheckIn.Service.QRCodeService;
import com.fabrica.CheckIn.model.TarjetaEmbargue;
import com.fabrica.CheckIn.repository.ContactoEmergenciaRepository;
import com.fabrica.CheckIn.repository.InfoPasajeroRepository;
import com.fabrica.CheckIn.repository.TarjetaEmbargueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TarjetaEmbargueController {

    @Autowired
    private InfoPasajeroRepository infoPasajeroRepository;

    @Autowired
    private ContactoEmergenciaRepository contactoEmergenciaRepository;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private TarjetaEmbargueRepository tarjetaEmbargueRepository;

    @MutationMapping
    public TarjetaEmbargue crearTarjetaEmbargue(@Argument String nombreCompleto) {
        try {
            // Generar un código QR único en base a algún identificador o al nombre
            String contenidoQR = "ID-" + nombreCompleto + "-" + System.currentTimeMillis();
            String qrBase64 = qrCodeService.generateQRCodeImageBase64(contenidoQR, 200, 200);

            // Crear la tarjeta de embarque con el código QR y nombre
            TarjetaEmbargue tarjeta = new TarjetaEmbargue();
            tarjeta.setNombreCompleto(nombreCompleto);
            tarjeta.setQrUnico(qrBase64);

            // Guardar en el repositorio
            return tarjetaEmbargueRepository.save(tarjeta);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear la tarjeta de embarque", e);
        }
    }

    @QueryMapping
    public TarjetaEmbargue consultarTarjetaEmbargue(@Argument Long idTarjetaEmbargue) {
        return tarjetaEmbargueRepository.findById(idTarjetaEmbargue)

                .orElseThrow(() -> new RuntimeException("Tarjeta de embarque no encontrada con ID: " + idTarjetaEmbargue));
    }


}
