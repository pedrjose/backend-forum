package com.cinema_vault.forum.repository;// OK!

import org.springframework.data.jpa.repository.JpaRepository;
//import com.cinema_vault.forum.Topico;

import com.cinema_vault.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
