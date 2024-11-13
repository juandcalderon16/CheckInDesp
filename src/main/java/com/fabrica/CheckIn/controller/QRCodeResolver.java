package com.fabrica.CheckIn.controller;

import com.fabrica.CheckIn.Service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QRCodeResolver {

    @Autowired
    private QRCodeService qrCodeService;

    @QueryMapping
    public String generateQRCode(@Argument String text) {
        try {
            return qrCodeService.generateQRCodeImageBase64(text, 200, 200);
        } catch (Exception e) {
            throw new RuntimeException("Error generating QR code", e);
        }
    }
}

