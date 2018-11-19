package com.umg.programacion2.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Puestos;


@Repository
public interface PuestoRepository extends CrudRepository<Puestos, Long>{

	List<Puestos> findAll();
	Puestos findByIdPuesto(Long id);
}
