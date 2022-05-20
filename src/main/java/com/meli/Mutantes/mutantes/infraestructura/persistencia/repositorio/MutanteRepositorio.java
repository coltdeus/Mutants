package com.meli.Mutantes.mutantes.infraestructura.persistencia.repositorio;

import com.meli.Mutantes.mutantes.dominio.modelo.Mutante;
import com.meli.Mutantes.mutantes.dominio.repositorio.MutanteRepositorioInterface;
import com.meli.Mutantes.mutantes.infraestructura.persistencia.crud.MutanteCrudInterface;
import com.meli.Mutantes.mutantes.infraestructura.persistencia.entidad.MutanteEntidad;
import com.meli.Mutantes.mutantes.infraestructura.persistencia.fabricaMapper.MutanteMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MutanteRepositorio implements MutanteRepositorioInterface {

    @Autowired
    private MutanteMapper mutanteMapper;

    @Autowired
    private MutanteCrudInterface mutanteCrudInterface;


    @Override
    public Optional<Mutante> findId(Integer id) {
        Optional<MutanteEntidad> mutanteEntidad = mutanteCrudInterface.findById(id);
        return mutanteEntidad.map(mutanteEntidadADto -> mutanteMapper.toMutanteDto(mutanteEntidadADto));
    }

    @Override
    public void save(Mutante mutante) {
        MutanteEntidad mutanteEntidad = mutanteMapper.toMutanteEntity(mutante);
        mutanteCrudInterface.save(mutanteEntidad);
    }

    @Override
    public List<Mutante> findAll() {
        List<MutanteEntidad> mutanteEntidads = mutanteCrudInterface.findAll();
        return mutanteMapper.toMutanteDtos(mutanteEntidads);
    }
}
