package com.umg.programacion2.serviceImpl;

import java.io.IOException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.umg.programacion2.model.Marcas;
import com.umg.programacion2.model.Productos;
import com.umg.programacion2.model.Puestos;
import com.umg.programacion2.repository.MarcasRepository;
import com.umg.programacion2.repository.ProductosRepository;
import com.umg.programacion2.service.ProductosService;
@Service
public class ProductosServiceImpl implements ProductosService{

	private static Logger logger = LoggerFactory.getLogger(ProductosServiceImpl.class);
	private static final String codigoCorrecto="success";
	private static final String codigoERROR="error";
	//private static final String Puestos = null;
	
	
	@Autowired MarcasRepository marcasRepository;
	@Autowired ProductosRepository productosRepository;
	@Override
	public List<Productos> getAllProductos() {
		List<Productos> productos = new ArrayList<Productos>();
		try {
			productos = productosRepository.findAll();
			
		}catch(Exception e) {
			logger.info("Error saveProductos "+e);
			return null;
		}
		return productos;
	}
	@Override
	public String saveProductos(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		String productos= request.getParameter("productos");
		//String nombre= request.getParameter("nombre");
		String imagen= request.getParameter("imagen");
		String precio_costo= request.getParameter("precio_costo");
		String precio_venta= request.getParameter("precio_venta");
		String existencia= request.getParameter("existencia");
		String fecha_ingreso= request.getParameter("fecha_ingreso");
		String marca= request.getParameter("marcas");
		String descripcion= request.getParameter("descripcion");
		imagen = convertImage(request);
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		
			logger.info(imagen);
			
		 
		
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
	
		Date fechaIng = null;
	
		try {
			
			fechaIng = format.parse(fecha_ingreso);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		Agregando puesto 
		Marcas  m = new Marcas();
		m.setIdmarcas(Long.parseLong(marca));
		
//		Guardando todos los parametros en empleado
		
		Productos producto = new Productos();
		producto.setProducto(productos);
		producto.setImagen(imagen);
		producto.setPrecio_costo(precio_costo);
		producto.setPrecio_venta(precio_venta);
		producto.setExistencia(existencia);
		producto.setFecha_ingreso(fechaIng);
		producto.setMarcas(m);
		producto.setDescripcion(descripcion);
		String res;
		try {
			productosRepository.save(producto);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Save Productos"+e);	
		}
		
		return res;
	}
	@Override
	public Productos getProductosId(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Productos productos =new Productos();
		try {
			productos =productosRepository.findByIdProductos(id);
			
		}catch(Exception e)
		{
		
			logger.info("ERROR Get Productos"+e);
		}
		return productos;
	}
	@Override
	public String updateProductos(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id= Long.parseLong(request.getParameter("idProducto"));
		String producto = request.getParameter("productos");
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String precio_costo = request.getParameter("precio_costo");
		String precio_venta = request.getParameter("precio_venta");
		String existencia = request.getParameter("existencia");
		String fechaIngreso= request.getParameter("fecha_ingreso");
		String marca= request.getParameter("marcas");
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		logger.info("Productos "+producto);
		imagen = convertImage(request);
//		CONVERTIR STRING A FECHA USAR DATE DE UTIL NO DE SQL
		
		
		Date fechaIng = null;
		
		try {
			
			fechaIng = format.parse(fechaIngreso);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		Agregando puesto 	
		
		Marcas  m = new Marcas();
		m.setIdmarcas(Long.parseLong(marca));
		
//		Guardando todos los parametros en empleado
		
		Productos productos = new Productos();
		productos.setIdProducto(id);
		productos.setProducto(producto);
		productos.setDescripcion(descripcion);
		productos.setImagen(imagen);
		productos.setPrecio_costo(precio_costo);
		productos.setPrecio_venta(precio_venta);
		productos.setExistencia(existencia);
		productos.setFecha_ingreso(fechaIng);
		productos.setMarcas(m);
	
		String res;
		
		try {
			productosRepository.save(productos);
			res=codigoCorrecto;
		}catch(Exception e)
		{
			res=codigoERROR;
			logger.info("Error Update Productos"+e);	
		}
		
		return res;

	}
		
	@Override
	public String deleteProductos(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("id"));
		Productos productos =new Productos();
		productos.setIdProducto(id);
		String respuesta="";
		try {
			productosRepository.delete(productos);
			respuesta =codigoCorrecto;
		}catch(Exception e)
		{
			respuesta = codigoERROR;
			logger.info("ERROR deletePuesto"+e);
		}
		return respuesta;
	}
	
	
	public String convertImage(MultipartHttpServletRequest request) throws IOException
	{
	    
	    Iterator<String> iterator = request.getFileNames();
	    MultipartFile imageVa = null;

	    while (iterator.hasNext()) {
	        String key = (String) iterator.next();
	        imageVa =request.getFile(key);
	        // create multipartFile array if you upload multiple files
	    }

		
		String val=imageVa.getBytes().toString();
		byte [] codificado =  Base64.encodeBase64 (imageVa.getBytes());
	    String base64Encoded = new String(codificado, "UTF-8");
	    return base64Encoded;
		
	}
	


	
}