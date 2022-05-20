package com.meli.Mutantes.mutantes.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mutante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MutanteEntidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String adn;

    @Column(nullable = false)
    private String countMutantDna;

    @Column(nullable = false)
    private String countHumanDna;

    @Column(nullable = false)
    private String ratio;

}
