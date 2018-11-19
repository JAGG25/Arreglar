package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Proveedores;
@Repository
public interface ProveedoresRepository extends CrudRepository<Proveedores, Long>{
	
	List<Proveedores> findAll();
	
	@Query("Select p from Proveedores p where p.idProveedore=?1")
	Proveedores findByIdProveedores(Long id);
}
