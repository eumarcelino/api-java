package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
}
