package com.meli.Mutantes.mutantes.aplicacion.manejador.mutante;

import com.meli.Mutantes.mutantes.aplicacion.comando.MutanteSalida;
import com.meli.Mutantes.mutantes.dominio.modelo.Mutante;
import com.meli.Mutantes.mutantes.dominio.repositorio.MutanteRepositorioInterface;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ManejadorEncontrarRegistros {

    private final MutanteRepositorioInterface mutanteRepositorioInterface;

    public List<MutanteSalida> statMutantes() {
        List<Mutante> mutantes = mutanteRepositorioInterface.findAll();
        List<MutanteSalida> mutanteSalidas = new ArrayList<>();
        MutanteSalida mutanteSalida;
        for(Mutante mutante : mutantes){
            mutanteSalida = MutanteSalida.builder()
                    .adn(mutante.getAdn())
                    .countMutantDna(mutante.getCountMutantDna())
                    .countHumanDna(mutante.getCountHumanDna())
                    .ratio(mutante.getRatio())
                    .build();
            mutanteSalidas.add(mutanteSalida);
        }
        return mutanteSalidas;
    }

}
