package com.meli.Mutantes.mutantes.dominio.modelo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Mutante {

    private Integer id;
    private String adn;
    private String countMutantDna;
    private String countHumanDna;
    private String ratio;

}
