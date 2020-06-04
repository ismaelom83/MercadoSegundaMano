package com.mercadoSegundaMano.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadoSegundaMano.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findFirstByEmail(String email);
}
