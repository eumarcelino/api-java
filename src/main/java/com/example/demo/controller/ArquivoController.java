package com.example.demo.controller;

import com.example.demo.entity.Arquivo;
import com.example.demo.service.ArquivoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/arquivos")
@AllArgsConstructor

public class ArquivoController {


    private ArquivoService service;

    @PostMapping("/upload")
    public Arquivo uploadArquivo(@RequestParam ("file") MultipartFile file) {
        String nomeArquivo = service.salvarArquivo(file);

        String caminhoArquivo = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/arquivos/downloaArquivo")
                .path(nomeArquivo)
                .toUriString();

        return  new Arquivo(nomeArquivo, caminhoArquivo,file.getContentType(), file.getSize());
    }

    @GetMapping("/downloaArquivo/{nomeArquivo}")
    public ResponseEntity<Resource> downloaArquivo (@PathVariable String nomeArquivo, HttpServletRequest request) {

        Resource resource = service.carregarArquivo (nomeArquivo);

        String contentType = service.getContentType(request, resource);

        return ResponseEntity.ok ()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}