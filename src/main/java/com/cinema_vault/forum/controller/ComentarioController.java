package com.cinema_vault.forum.controller;
// ATUALIZADA
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cinema_vault.forum.dto.comentario.ComentarioRequestDTO;
import com.cinema_vault.forum.dto.comentario.ComentarioResponseDTO;
import com.cinema_vault.forum.model.Comentario;
import com.cinema_vault.forum.model.Topico;
import com.cinema_vault.forum.repository.ComentarioRepository;
import com.cinema_vault.forum.repository.TopicoRepository;


@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<?> criarComentario(@RequestBody ComentarioRequestDTO comentarioDTO){
        Topico topico = topicoRepository.findById(comentarioDTO.getTopicoId())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setMensagem(comentarioDTO.getMensagem());
        comentario.setAutor(comentarioDTO.getAutor());
        comentario.setTopico(topico);
        comentario.setDataCriacao(java.time.LocalDateTime.now());

        comentarioRepository.save(comentario);

        return ResponseEntity.ok(new ComentarioResponseDTO(comentario));
    }
}

