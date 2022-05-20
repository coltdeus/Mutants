package com.meli.Mutantes.mutantes.infraestructura.endPoint.mutante;

import com.meli.Mutantes.mutantes.aplicacion.comando.MutanteSalida;
import com.meli.Mutantes.mutantes.aplicacion.manejador.mutante.ManejadorEncontrarRegistros;
import com.meli.Mutantes.mutantes.aplicacion.manejador.mutante.ManejadorVerificarMutante;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointStats {

    private ManejadorEncontrarRegistros manejadorEncontrarRegistros;

    @GetMapping("/mutant")
    public ResponseEntity<List<MutanteSalida>> isMutant(String[] adn){
        List<MutanteSalida> mutanteSalidas = manejadorEncontrarRegistros.statMutantes();
        return new ResponseEntity<>(mutanteSalidas, HttpStatus.ACCEPTED);
    }
}
