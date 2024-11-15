package com.fabrica.CheckIn.repository;

import com.fabrica.CheckIn.model.TarjetaEmbarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaEmbarqueRepository extends JpaRepository<TarjetaEmbarque, Long> {
}
