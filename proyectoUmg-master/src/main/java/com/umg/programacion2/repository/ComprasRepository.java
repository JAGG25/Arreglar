package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Compras;

@Repository
public interface ComprasRepository extends CrudRepository<Compras, Long>{
	
	List<Compras> findAll();
	
	@Query("Select c from Compras c where c.id=?1")
	Compras findByIdCompras(Long id);
}
