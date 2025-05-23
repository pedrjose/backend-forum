package com.cinema_vault.forum.repository;
//import com.cinema_vault.forum.controller;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema_vault.forum.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
