package apirest.modelo.service;

import java.util.List;

import apirest.modelo.entities.Familia;

public interface FamiliaService {
	List<Familia> findAll();
	Familia findById(int idFamilia);
	Familia insertOne(Familia familia);
	Familia modificarOne(Familia familia);
	boolean deleteOne(int idFamilia);
	

}
