package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Arquivo {
    private  String nomeArquivo;
    private String linkDownload;
    private String extensaoArquivo;
    private long size;
}
