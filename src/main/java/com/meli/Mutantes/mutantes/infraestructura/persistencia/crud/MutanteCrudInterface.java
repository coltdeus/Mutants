package com.meli.Mutantes.mutantes.infraestructura.persistencia.crud;

import com.meli.Mutantes.mutantes.infraestructura.persistencia.entidad.MutanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MutanteCrudInterface extends JpaRepository<MutanteEntidad, Integer> {

    Optional<MutanteEntidad> findById (String id);

    List<MutanteEntidad> findAll();

}
