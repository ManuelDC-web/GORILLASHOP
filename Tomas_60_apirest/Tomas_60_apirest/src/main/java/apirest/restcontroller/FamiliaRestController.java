package apirest.restcontroller;

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
import apirest.modelo.service.FamiliaService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/familias/productos/")
public class FamiliaRestController {
	
	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping("/saludo")
	public Map<String, String> saludo() {
		Map<String,String> mensajes = new HashMap<>();
		mensajes.put("mensaje", "Hola me llamo Tomasin");
		return mensajes;
	}
	/**
	 * devuelve todas las familias de la base de datos
	 * @return
	 */
	@GetMapping("/")
	public List<Familia> todasFamilias() {
		return familiaService.findAll();
	}
	
	@GetMapping("/{idFamilia}")
	public Familia una(@PathVariable int idFamilia) {
		return familiaService.findById(idFamilia);
	}
	
	@DeleteMapping("/{idFamilia}")
	public String eliminar(@PathVariable int idFamilia) {
		return familiaService.deleteOne(idFamilia)
							? "Familia eliminada" 
							: "No se ha podido eliminar";
	}
	
	@PostMapping("/")
	public Familia altaFamilia(@RequestBody Familia familia) {
		return familiaService.insertOne(familia);
	}
	
	@PutMapping("/")
	public Familia modificarFamilia(@RequestBody Familia familia) {
		return familiaService.modificarOne(familia);
	}
	
	
	
	
	

}
