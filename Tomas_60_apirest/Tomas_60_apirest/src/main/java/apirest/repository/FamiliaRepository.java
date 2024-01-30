package apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apirest.modelo.entities.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Integer>{

}
