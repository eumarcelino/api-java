package com.example.demo.service;

import com.example.demo.config.ArquivoStorageProperties;
import exception.UploadArquivoException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ArquivoService {

    private final Path fileStorageLocation;

    public  ArquivoService(ArquivoStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath() .normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new UploadArquivoException("Algo deu errado ao tentar criar a pasta", e);
        }
    }
}
