package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Ventas;
@Repository
public interface VentasRepository extends CrudRepository<Ventas, Long>{
List<Ventas> findAll();
	
	@Query("Select v from Ventas v where v.idVenta=?1")
	Ventas findByIdVenta(Long id);

}
