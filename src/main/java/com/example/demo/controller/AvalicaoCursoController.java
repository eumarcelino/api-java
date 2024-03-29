package com.example.demo.controller;

import com.example.demo.service.AvaliacaoCursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/avaliacoes")
public class AvalicaoCursoController {

    private final AvaliacaoCursoService avaliacaoService;

    @PostMapping
    public ResponseEntity<String> avaliar (
            @RequestParam Long idEstudante,
            @RequestParam String nomeCurso,
            @RequestParam Integer notaAvaliacao) {
        return avaliacaoService.avaliar (idEstudante, nomeCurso,notaAvaliacao);
    }
}
