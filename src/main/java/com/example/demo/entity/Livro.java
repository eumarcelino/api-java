package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Livro {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private  Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn (name = "estudante_id", nullable = false)
    @JsonIgnore
    private Estudante estudante;
}
