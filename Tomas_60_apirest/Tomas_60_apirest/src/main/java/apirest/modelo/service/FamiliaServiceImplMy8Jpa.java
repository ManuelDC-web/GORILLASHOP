package apirest.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.modelo.entities.Familia;
import apirest.repository.FamiliaRepository;
@Service
public class FamiliaServiceImplMy8Jpa implements FamiliaService{
	@Autowired
	private FamiliaRepository frepo;

	@Override
	public List<Familia> findAll() {
		// TODO Auto-generated method stub
		return frepo.findAll();
	}

	@Override
	public Familia findById(int idFamilia) {
		// TODO Auto-generated method stub
		return frepo.findById(idFamilia).orElse(null);
	}

	@Override
	public Familia insertOne(Familia familia) {
		try {
			return frepo.save(familia);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Familia modificarOne(Familia familia) {
		try {
		if (findById(familia.getIdFamilia()) != null)
			return frepo.save(familia);
		else
			return null;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteOne(int idFamilia) {
		try {
			frepo.deleteById(idFamilia);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	

}
