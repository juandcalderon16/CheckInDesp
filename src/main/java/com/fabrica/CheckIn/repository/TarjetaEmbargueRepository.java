package com.fabrica.CheckIn.repository;

import com.fabrica.CheckIn.model.TarjetaEmbargue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaEmbargueRepository extends JpaRepository<TarjetaEmbargue, Long> {
}
