package com.meli.Mutantes.mutantes.infraestructura.configuracion;

import com.meli.Mutantes.mutantes.aplicacion.manejador.mutante.ManejadorEncontrarRegistros;
import com.meli.Mutantes.mutantes.aplicacion.manejador.mutante.ManejadorVerificarMutante;
import com.meli.Mutantes.mutantes.dominio.repositorio.MutanteRepositorioInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracion {

    @Bean
    public ManejadorVerificarMutante manejadorVerificarMutante(MutanteRepositorioInterface mutanteRepositorioInterface) {
        return new ManejadorVerificarMutante(mutanteRepositorioInterface);
    }

    @Bean
    public ManejadorEncontrarRegistros manejadorEncontrarRegistros(MutanteRepositorioInterface mutanteRepositorioInterface) {
        return new ManejadorEncontrarRegistros(mutanteRepositorioInterface);
    }

}
