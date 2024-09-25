package com.example.demo.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class AvaliacaoCurso {

    @EmbeddedId
    private AvaliacaoCursoKey id = new AvaliacaoCursoKey();

    @ManyToOne
    @MapsId("estudanteID")
    @JoinColumn (name = "estudante_id")
    Estudante estudante;

    @ManyToOne
    @MapsId("cursoID")
    @JoinColumn (name = "curso_id")
    Curso curso;

    int notaDaAvaliacao;
}
