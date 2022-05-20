package com.meli.Mutantes.mutantes.infraestructura.endPoint.mutante;

import com.meli.Mutantes.mutantes.aplicacion.comando.MutanteEntrada;
import com.meli.Mutantes.mutantes.aplicacion.manejador.mutante.ManejadorVerificarMutante;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "*")
public class EndPointVerificar {

    @Autowired
    private ManejadorVerificarMutante manejadorVerificarMutante;

    @PostMapping("/stats")
    @ApiOperation("Detector de mutantes por medio del ADN")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 403, message = "Forbidden")
    })
    public ResponseEntity<MutanteEntrada> save(@RequestBody MutanteEntrada mutanteEntrada) throws NotFoundException {
        Boolean isMutant = manejadorVerificarMutante.verificar(mutanteEntrada);
        if (!isMutant){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
