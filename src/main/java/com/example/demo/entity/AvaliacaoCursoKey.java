package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor

public class AvaliacaoCursoKey implements Serializable {

    private static final long serialVesionUID =  1L;

    @Column (name = "estudante_id")
    Long estudanteID;

    @Column (name = "curso_id")
    Long cursoID;
}
