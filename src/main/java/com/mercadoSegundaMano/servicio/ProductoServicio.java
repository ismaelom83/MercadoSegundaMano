package com.mercadoSegundaMano.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadoSegundaMano.modelo.Compra;
import com.mercadoSegundaMano.modelo.Producto;
import com.mercadoSegundaMano.modelo.Usuario;
import com.mercadoSegundaMano.repositorios.ProductoRepository;
import com.mercadoSegundaMano.upload.StorageService;

@Service
public class ProductoServicio {
	
	@Autowired
	ProductoRepository repositorio;
	
	@Autowired
	StorageService storageService;
	
	public Producto insertar(Producto p) {
		return repositorio.save(p);
	}
	
	public void borrar(long id) {
		repositorio.deleteById(id);
	}
	

	
	public Producto editar(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Producto> findAll() {
		return repositorio.findAll();
	}
	
	public void borrar(Producto p) {
		if (!p.getImagen().isEmpty())
			storageService.delete(p.getImagen());
		repositorio.delete(p);
	}
	
	public List<Producto> productosDeUnPropietario(Usuario u) {
		return repositorio.findByPropietario(u);
	}
	
	public List<Producto> productosDeUnaCompra(Compra c) {
		return repositorio.findByCompra(c);
	}
	
	public List<Producto> productosSinVender() {
		return repositorio.findByCompraIsNull();
	}
	
	public List<Producto> buscar(String query) {
		return repositorio.findByNombreContainsIgnoreCaseAndCompraIsNull(query);
	}
	
	public List<Producto> buscarMisProductos(String query, Usuario u) {
		return repositorio.findByNombreContainsIgnoreCaseAndPropietario(query,u);
	}
	
	public List<Producto> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}
	
}
