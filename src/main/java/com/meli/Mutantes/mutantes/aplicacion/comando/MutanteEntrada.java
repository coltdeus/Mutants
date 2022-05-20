package com.meli.Mutantes.mutantes.aplicacion.comando;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class MutanteEntrada {
    
    private String[] dna;

    public boolean esValido(){
        if (dna != null) {
            for (int i = 0; i < dna.length; i++) {
                String s = dna[i];
                if (s.length() != dna.length) {
                    return Boolean.FALSE;
                }
            }
        } else {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
