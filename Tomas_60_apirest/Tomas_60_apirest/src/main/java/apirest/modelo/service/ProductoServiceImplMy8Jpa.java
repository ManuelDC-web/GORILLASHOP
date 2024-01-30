package apirest.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.modelo.entities.Producto;
import apirest.repository.ProductoRepository;

@Service
public class ProductoServiceImplMy8Jpa implements ProductoService{
	
	@Autowired
	private ProductoRepository prepo;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public Producto findById(int idProducto) {
		// TODO Auto-generated method stub
		return prepo.findById(idProducto).orElse(null);
	}

	@Override
	public Producto insertOne(Producto producto) {
		try {
			return prepo.save(producto);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Producto modificarOne(Producto producto) {
		try {
			if (findById(producto.getIdProducto()) != null)
				return prepo.save(producto);
			else
				return null;
			}catch(Exception e) {
				return null;
			}
	}

	@Override
	public boolean deleteOne(int idProducto) {
		try {
			prepo.deleteById(idProducto);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Producto> buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return prepo.findByMarca(marca);
	}

	@Override
	public List<Producto> buscarPorDescripcion(String cadena) {
		// TODO Auto-generated method stub
		return prepo.findByDescripcionContains(cadena);
	}

	@Override
	public List<Producto> buscarPorFamilia(int idFamilia) {
		// TODO Auto-generated method stub
		return prepo.findByFamilia(idFamilia);
	}
	
	

}
