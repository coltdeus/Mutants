package com.meli.Mutantes.mutantes.aplicacion.manejador.mutante;

import com.meli.Mutantes.mutantes.aplicacion.comando.MutanteEntrada;
import com.meli.Mutantes.mutantes.dominio.repositorio.MutanteRepositorioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ManejadorVerificarMutante {

    private final MutanteRepositorioInterface mutanteRepositorioInterface;

    private static final String[] SECUENCIAS_ADN = {"AAAA", "CCCC", "GGGG", "TTTT"};
    public int tamano;
    private static int filas[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int columnas[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    private int contador = 0;

    public ManejadorVerificarMutante() {
        mutanteRepositorioInterface = null;
    }

    public Boolean verificar(MutanteEntrada mutanteEntrada) {
        boolean isMutant = false;
        if (mutanteEntrada.esValido())
            isMutant = isMutant(mutanteEntrada.getDna());
        return isMutant;
    }

    public boolean isMutant(String[] dna){
        return analizarADN(dna);
    }

    public boolean analizarADN(String[] adn){
        for (String secuenciaADN : SECUENCIAS_ADN) {
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    secuencia(adn, i, j, secuenciaADN);
                    if (contador >= 2) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    private void secuencia(String[] adn, int fila, int columna, String secuencia){

        if (adn[fila].charAt(columna) != secuencia.charAt(0)) {
            return;
        }

        int len = secuencia.length();

        for (int dir = 0; dir < 8; ++dir) {
            int rowDir = fila + filas[dir];
            int colDir = columna + columnas[dir];
            int i;

            for (i = 1; i <= len - 1; i++) {

                if (!esSeguro(rowDir, colDir)) {
                    break;

                }

                if (!(adn[rowDir].charAt(colDir) == secuencia.charAt(i))) {
                    break;
                }

                rowDir = rowDir + filas[dir];
                colDir = colDir + columnas[dir];
            }

            if (i == len) {
                contador++;

                if (contador >= 2) {
                    return;
                }
            }
        }
    }

    boolean esSeguro(int i, int j) {
        if (i >= 0 && i <= (tamano - 1) && j >= 0 && j <= tamano - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] adn = {"AAAAGA","ACGTTC","ATATGT","AGAAGG","CACCTA","TCACTG"};

        ManejadorVerificarMutante ma = new ManejadorVerificarMutante();

        boolean mutant = ma.analizarADN(adn);
        System.out.println("Mutante: " + mutant);
    }
}