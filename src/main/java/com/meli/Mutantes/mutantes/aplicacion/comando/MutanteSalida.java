package com.meli.Mutantes.mutantes.aplicacion.comando;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MutanteSalida {

    private String adn;
    private String countMutantDna;
    private String countHumanDna;
    private String ratio;

}
