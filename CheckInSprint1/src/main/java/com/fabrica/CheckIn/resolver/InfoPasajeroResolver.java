package com.fabrica.CheckIn.resolver;


import com.fabrica.CheckIn.model.InfoPasajero;
import com.fabrica.CheckIn.service.InfoPasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoPasajeroResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private InfoPasajeroService infoPasajeroService;

    // Consultas
    public InfoPasajero infoPasajero(Long id) {
        return infoPasajeroService.findById(id);
    }

    public List<InfoPasajero> infoPasajeros() {
        return infoPasajeroService.findAll();
    }

    // Mutaciones
    public InfoPasajero ingresarInfoPasajero(String nombre, Integer edad) {
        InfoPasajero infoPasajero = new InfoPasajero();
        infoPasajero.setNombre(nombre);
        infoPasajero.setEdad(edad);
        return infoPasajeroService.ingresarInfoPasajero(infoPasajero);
    }
}
