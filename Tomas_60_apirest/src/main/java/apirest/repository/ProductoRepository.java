package apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apirest.modelo.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	@Query("select p from Producto p where p.familia.idFamilia=?1")
	public List<Producto>  findByFamilia(int idFamilia);
	
	public List<Producto> findByDescripcionContains(String cadena);
	public List<Producto> findByMarca(String marca);
	

}
