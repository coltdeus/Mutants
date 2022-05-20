package com.meli.Mutantes.mutantes.dominio.repositorio;

import com.meli.Mutantes.mutantes.dominio.modelo.Mutante;

import java.util.List;
import java.util.Optional;

public interface MutanteRepositorioInterface {

    Optional<Mutante> findId(Integer id);

    void save(Mutante mutante);

    List<Mutante> findAll();

}
