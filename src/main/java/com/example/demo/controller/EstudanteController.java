package com.example.demo.controller;


import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("estudantes")
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    }

    @GetMapping
    public Page<Estudante> buscarTodosEstudantes (
            @RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "5") Integer itensPorPagina) {
        return estudanteService.buscarTodosEstudantes(PageRequest.of(pagina, itensPorPagina));
    }

    @PostMapping
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizarEstudante(
            @PathVariable Long id, @RequestBody Estudante estudante) {
        return estudanteService.atualizarEstudante(id, estudante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerEstudante(@PathVariable Long id) {
        return estudanteService.removerEstudante(id);
    }

}
