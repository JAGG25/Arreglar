package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Estudiante;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long>{
	
	List<Estudiante> findAll();

}
