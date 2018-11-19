package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Productos;
@Repository
public interface ProductosRepository extends CrudRepository<Productos, Long>{
	
	List<Productos> findAll();
	
	@Query("Select p from Productos p where p.id=?1")
	Productos findByIdProductos(Long id);
}
