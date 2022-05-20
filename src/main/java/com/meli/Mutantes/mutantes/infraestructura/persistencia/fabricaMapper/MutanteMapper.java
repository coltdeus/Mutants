package com.meli.Mutantes.mutantes.infraestructura.persistencia.fabricaMapper;

import com.meli.Mutantes.mutantes.dominio.modelo.Mutante;
import com.meli.Mutantes.mutantes.infraestructura.persistencia.entidad.MutanteEntidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MutanteMapper {

    Mutante toMutanteDto(MutanteEntidad mutanteEntidad);

    List<Mutante> toMutanteDtos(List<MutanteEntidad> mutanteEntidads);

    @InheritInverseConfiguration
    MutanteEntidad toMutanteEntity(Mutante mutante);

}
