package com.fabrica.CheckIn.service;

import com.fabrica.CheckIn.model.InfoPasajero;
import com.fabrica.CheckIn.repository.InfoPasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoPasajeroService {

    @Autowired
    private InfoPasajeroRepository infoPasajeroRepository;

    public List<InfoPasajero> findAll() {return infoPasajeroRepository.findAll();}
    public InfoPasajero findById(Long id) {return infoPasajeroRepository.findById(id).orElse(null);}
    public void ingresarInfoPasajero(InfoPasajero infoPasajero) {infoPasajeroRepository.save(infoPasajero);}

}
