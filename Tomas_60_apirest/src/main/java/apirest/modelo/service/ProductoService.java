package apirest.modelo.service;

import java.util.List;


import apirest.modelo.entities.Producto;

public interface ProductoService {
	List<Producto> findAll();
	Producto findById(int idProducto);
	Producto insertOne(Producto producto);
	Producto modificarOne(Producto producto);
	boolean deleteOne(int idProducto);
	List<Producto> buscarPorMarca(String marca);
	List<Producto> buscarPorDescripcion(String cadena);
	List<Producto> buscarPorFamilia(int idFamilia);
	
	

}
