package com.cinema_vault.forum.dto;

import java.time.LocalDateTime;

public class RespostaDTO {
    private Long id;
    private String titulo;
    private String mensagen;
    private LocalDateTime dataCriacao;
    
    public RespostaDTO(Long id, String titulo, String mensagen, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.mensagen = mensagen;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagen() {
        return mensagen;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    } 

    
    
}
