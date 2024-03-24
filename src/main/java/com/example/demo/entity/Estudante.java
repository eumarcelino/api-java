package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Livro> livros = new HashSet<>();

    @OneToMany(mappedBy = "estudante")
    private Set<AvaliacaoCurso> avaliacaoCursos;

}
