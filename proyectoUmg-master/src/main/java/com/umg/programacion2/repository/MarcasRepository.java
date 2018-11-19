package com.umg.programacion2.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Marcas;



@Repository
public interface MarcasRepository extends CrudRepository<Marcas, Long>{

	List<Marcas> findAll();
	Marcas findByIdmarcas(Long id);
}
