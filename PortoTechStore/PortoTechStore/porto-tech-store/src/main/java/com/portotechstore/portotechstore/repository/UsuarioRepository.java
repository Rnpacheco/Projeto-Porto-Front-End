package com.portotechstore.portotechstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portotechstore.portotechstore.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
	public Optional<UsuarioModel> findByUsername(String username);
}
