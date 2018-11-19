package com.umg.programacion2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umg.programacion2.model.Cliente;
import com.umg.programacion2.model.Empleado;
import com.umg.programacion2.model.Ventas;
@Repository
public interface ClienteRepostory extends CrudRepository<Cliente, Long>{
	List<Cliente> findAll();
		
		@Query("Select c from Cliente c where c.idCliente=?1")
		Cliente findByIdCliente(Long id);

}
