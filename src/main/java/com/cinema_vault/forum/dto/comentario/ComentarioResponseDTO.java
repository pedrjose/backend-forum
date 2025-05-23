package com.cinema_vault.forum.dto.comentario;

//import com.cinema_vault.forum.Comentario;
import java.time.LocalDateTime;

import com.cinema_vault.forum.model.Comentario;

public class ComentarioResponseDTO {

    private Long id;
    private String mensagem;
    private String autor;
    private LocalDateTime dataCriacao;

    public ComentarioResponseDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.mensagem = comentario.getMensagem();
        this.autor = comentario.getAutor();
        this.dataCriacao = comentario.getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
