package com.mercadoSegundaMano.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadoSegundaMano.modelo.Compra;
import com.mercadoSegundaMano.modelo.Usuario;

public interface CompraRepository extends JpaRepository<Compra, Long> {
	
	List<Compra> findByPropietario(Usuario propietario);
}
