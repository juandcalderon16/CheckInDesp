package com.fabrica.CheckIn.controller;

import com.fabrica.CheckIn.Service.QRCodeService;
import com.fabrica.CheckIn.model.TarjetaEmbarque;
import com.fabrica.CheckIn.repository.TarjetaEmbarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TarjetaEmbarqueController {

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private TarjetaEmbarqueRepository tarjetaEmbarqueRepository;

    @MutationMapping
    public TarjetaEmbarque crearTarjetaEmbarque(@Argument String nombreCompleto) {
        try {
            // Generar un código QR único en base a algún identificador o al nombre
            String contenidoQR = "ID-" + nombreCompleto + "-" + System.currentTimeMillis();
            String qrBase64 = qrCodeService.generateQRCodeImageBase64(contenidoQR, 200, 200);

            // Crear la tarjeta de embarque con el código QR y nombre
            TarjetaEmbarque tarjeta = new TarjetaEmbarque();
            tarjeta.setNombreCompleto(nombreCompleto);
            tarjeta.setQrUnico(qrBase64);

            // Guardar en el repositorio
            return tarjetaEmbarqueRepository.save(tarjeta);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear la tarjeta de embarque", e);
        }
    }

    @QueryMapping
    public TarjetaEmbarque consultarTarjetaEmbarque(@Argument Long idTarjetaEmbarque) {
        return tarjetaEmbarqueRepository.findById(idTarjetaEmbarque)

                .orElseThrow(() -> new RuntimeException("Tarjeta de embarque no encontrada con ID: " + idTarjetaEmbarque));
    }


}