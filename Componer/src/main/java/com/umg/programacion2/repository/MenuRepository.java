package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Menu;


@Repository
public interface MenuRepository extends CrudRepository<Menu, Long>{
	
	@Query("Select m from Menu m order by m.prioridad asc")
	List<Menu> findAll();
	
	@Query("Select m from Menu m where m.padre!=0")
	List<Menu> findAllChildren();

}
