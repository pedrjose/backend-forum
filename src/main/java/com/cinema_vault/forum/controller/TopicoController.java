package com.cinema_vault.forum.controller;

//import com.cinema_vault.forum.ComentarioRequestDTO;
//import com.cinema_vault.forum.ComentarioResponseDTO;
import org.springframework.web.bind.annotation.*;

import com.cinema_vault.forum.dto.TopicoDTO;
import com.cinema_vault.forum.dto.comentario.ComentarioRequestDTO;
import com.cinema_vault.forum.dto.comentario.ComentarioResponseDTO;
import com.cinema_vault.forum.model.Comentario;
import com.cinema_vault.forum.model.Topico;
import com.cinema_vault.forum.repository.TopicoRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @GetMapping
    public List<TopicoDTO> listar() {
        return topicoRepository.findAll()
            .stream()
            .map(TopicoDTO::new)
            .collect(Collectors.toList());
    }

    @PostMapping
    public TopicoDTO criarTopico(@RequestBody TopicoDTO dto) {
        Topico novo = new Topico();
        novo.setTitulo(dto.getTitulo());
        novo.setMensagem(dto.getMensagem());
        novo.setAutor(dto.getAutor());
        novo.setDataCriacao(java.time.LocalDateTime.now());

        Topico salvo = topicoRepository.save(novo);

        return new TopicoDTO(salvo);
    }

    @PostMapping("/{id}/comentarios")
    public ComentarioResponseDTO adicionarComentario(@PathVariable long id, @RequestBody ComentarioRequestDTO comentarioDTO) {
        Topico topico = topicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tópico não encontrado."));

        Comentario comentario = new Comentario(comentarioDTO.getMensagem(), comentarioDTO.getAutor());
        comentario.setTopico(topico);

        topico.adicionarComentario(comentario);
        topicoRepository.save(topico);

        return new ComentarioResponseDTO(comentario);
    }

    @GetMapping("/{id}/comentarios")
    public List<ComentarioResponseDTO> listarComentarios(@PathVariable long id) {
        Topico topico = topicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tópico não encontrado."));

        return topico.getComentarios()
                .stream()
                .map(ComentarioResponseDTO::new)
                .collect(Collectors.toList());
    }
}
