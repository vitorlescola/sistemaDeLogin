package com.sesi.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.login.model.Papel;

public interface PapelRepository extends JpaRepository<Papel,Long>{ //nome,tipo de id
	Papel findByNomePapel(String nomePapel);
}