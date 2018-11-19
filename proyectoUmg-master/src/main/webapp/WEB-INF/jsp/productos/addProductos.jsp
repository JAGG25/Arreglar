<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar</strong> Productos
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="addProductos" method="post" class="" id="formularioProductos" enctype="multipart/form-data">
                                            <div class="form-group">
                                                <label for="nombre" class=" form-control-label">Producto</label>
                                                <input type="text" id="productos" name="productos" placeholder="Nombre del  producto" class="form-control" required>
                                                
                                            </div>
                                     <div class="col-6">
                                     <label for="marcas" class=" form-control-label">Marca</label>
                                     <select id="marcas" name="marcas" class="form-control">
								     <option value="">Seleccione la marca</option>
							         <c:forEach items="${marcas}" var="m">
									 <option value="${m.idmarcas}">${m.marcas}</option>
									 </c:forEach>
									 </select> 
                                   	</div>
                                	<div class="row">
                              		<div class="col-6">
                                    	<label for="descripcion" class=" form-control-label">Descripcion</label>
                                    	<input type="text" id="descripcion" name="descripcion" placeholder="Descripcion" class="form-control" required>
                                    </div>
                                    </div>
                                    <div class="row">
                              		<div class="col-6">
                                    	<label for="imagen" class=" form-control-label">Imagen</label>
                                    	<input type="file" name="imagen" data-max-size="1048"/>
                                    </div>
                                    </div>
                                    <div class="row">
                              		<div class="col-6">
                                    	<label for="precio_costo" class=" form-control-label">Precio Costo</label>
                                    	<input type="text" id="precio_costo" name="precio_costo" placeholder="Precio Costo" class="form-control" required>
                                    </div>
                                    </div>	
                                    <div class="row">
                              		<div class="col-6">
                                    	<label for="precio_venta" class=" form-control-label">Precio Venta</label>
                                    	<input type="text" id="precio_venta" name="precio_venta" placeholder="Precio Venta" class="form-control" required>
                                    </div>
                                    </div>	
                                    <div class="row">
                              		<div class="col-6">
                                    	<label for="existencia" class=" form-control-label">Existencia</label>
                                    	<input type="text" id="existencia" name="existencia" placeholder="Existencia" class="form-control" required>
                                    </div>
                                    </div>
                                    <div class="row">
                                    <div class="col-6">
                            		<label for="fecha_ingreso" class=" form-control-label">Fecha de ingreso</label>
                                	<input type="text" id="fecha_ingreso" name="fecha_ingreso" placeholder="Fecha Ingreso" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                            	</div>
                            </div>
                                          
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarProductos" type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Guardar
                                        </button>
                                        <button id="regresar" type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Regresar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

<%@ include file = "../include/footer.jsp" %>


<script>
$(document).ready(function() {
	
	
	 $('#regresar').click(function(){
		 document.location.href = 'listProductos'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker();
});


</script>