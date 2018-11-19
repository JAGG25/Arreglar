package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Empleado;
@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{
	
	List<Empleado> findAll();
	
	@Query("Select e from Empleado e where e.id=?1")
	Empleado findByIdEmpleado(Long id);
}
