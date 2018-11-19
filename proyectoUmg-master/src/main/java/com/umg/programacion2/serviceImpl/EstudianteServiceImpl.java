package com.umg.programacion2.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.programacion2.model.Estudiante;
import com.umg.programacion2.repository.EstudianteRepository;
import com.umg.programacion2.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	private static Logger logger = LoggerFactory.getLogger(EstudianteServiceImpl.class);
	@Autowired EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> getAllEstudiantes() {
		List<Estudiante> es = new ArrayList<Estudiante>();
		try {
			es = estudianteRepository.findAll();
			
		}catch(Exception e)
		{
			logger.info("Error al obtener estudiantes "+e);
			return es;
		}
		return es;
	}

}
