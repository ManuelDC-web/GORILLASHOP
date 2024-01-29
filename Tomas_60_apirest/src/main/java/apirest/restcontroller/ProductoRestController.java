package apirest.restcontroller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apirest.modelo.entities.Familia;
import apirest.modelo.entities.Producto;
import apirest.modelo.service.FamiliaService;
import apirest.modelo.service.ProductoService;
import apirest.repository.FamiliaRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoRestController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private FamiliaService familiaService;
	
	
	
	/**
	 * devuelve todos los productos de la base de datos
	 * @return
	 */
	@GetMapping("/")
	public List<Producto> todos() {
		return productoService.findAll();
	}
	
	@GetMapping("/{idProducto}")
	public Producto una(@PathVariable int idProducto) {
		return productoService.findById(idProducto);
	}
	
	@GetMapping("/familia/{idFamilia}")
	public List<Producto> porFamilia(@PathVariable int idFamilia) {
		return productoService.buscarPorFamilia(idFamilia);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Producto> porMarca(@PathVariable String marca) {
		return productoService.buscarPorMarca(marca);
	}
	
	@GetMapping("/buscar/{cadena}")
	public List<Producto> porDescripcion(@PathVariable String cadena) {
		return productoService.buscarPorDescripcion(cadena);
	}
	
	
	@DeleteMapping("/{idProducto}")
	public String eliminar(@PathVariable int idProducto) {
		return productoService.deleteOne(idProducto)
							? "Producto eliminado" 
							: "No se ha podido eliminar";
	}
	
	@PostMapping("/")
	public Producto alta(@RequestBody Producto producto) {
		producto.setFechaAlta(new Date());
		
		Producto pro = productoService.insertOne(producto);
		pro.setFamilia(familiaService.findById(pro.getFamilia().getIdFamilia()));
		return pro;
		
		
	}
	
	@PutMapping("/")
	public Producto modificar(@RequestBody Producto producto) {
		return productoService.modificarOne(producto);
	}
	
	
	
	
	

}
