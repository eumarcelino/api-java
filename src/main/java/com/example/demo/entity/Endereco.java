package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;

    @OneToOne (mappedBy = "endereco")
    @JsonIgnore
    private  Estudante estudante;

}
