package com.cinema_vault.forum.dto.comentario;
// classe ATUALIZADA !!!

public class ComentarioRequestDTO {

    private String mensagem;
    private String autor;
    private Long topicoId; 

    public ComentarioRequestDTO() {}

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Long topicoId) {
        this.topicoId = topicoId;
    }
}
