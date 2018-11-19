<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar</strong> Empleado
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="addEmpleado" method="post" class="" id="formularioEmpleado">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="nombre" class=" form-control-label">Nombres</label>
                                                	<input type="text" id="nombres" name="nombres" placeholder="Nombres" class="form-control" required>
                                                </div>
                                                <div class="col-6">
                                                 	<label for="apellidos" class=" form-control-label">Apellidos</label>
                                                	<input type="text" id="apellidos" name="apellidos" placeholder="Apellidos" class="form-control" required>
                                                </div>
                                            </div>
                                            
                                            <div class="row">
                                            	<div class="col-6">
                                            		<label for="direccion" class=" form-control-label">Dirección</label>
                                                	<input type="text" id="direccion" name="direccion" placeholder="Dirección" class="form-control" required>
                                                </div>
                                             
                                                <div class="col-6">
                                                	<label for="telefono" class=" form-control-label">Telefono</label>
                                                	<input type="text" id="telefono" name="telefono" placeholder="####-####" class="form-control" required>
                                                </div>
                                            </div>
                                           
                                          	<div class="row">
                                          		<div class="col-6">
                                                	<label for="dpi" class=" form-control-label">DPI</label>
                                                	<input type="text" id="dpi" name="dpi" placeholder="Dpi" class="form-control" required>
                                                </div>
                                                <div class="col-6">
                                                	<div class="col">
	                                                    <label class=" form-control-label">Genero</label>
	                                                </div>
	                                                <div class="col">
	                                                    <div class="form-check-inline form-check">
	                                                        <label for="inline-radio1" class="form-check-label ">
	                                                            <input type="radio" id="genero1" name="genero" value="1" class="form-check-input">Hombre
	                                                        </label>
	                                                        <label for="inline-radio2" class="form-check-label ">
	                                                            <input type="radio" id="genero2" name="genero" value="0" class="form-check-input">Mujer
	                                                        </label>
	                                                        
	                                                    </div>
	                                                </div>
	                                             </div>
                                            </div>

                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fecha_nacimiento" class=" form-control-label">Fecha de nacimiento</label>
                                                	<input type="text" id="fecha_nacimiento" name="fecha_nacimiento" placeholder="Fecha Nacimiento" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            		<label for="fecha_ingreso" class=" form-control-label">Fecha de ingreso</label>
                                                	<input type="text" id="fecha_ingreso" name="fecha_ingreso" placeholder="Fecha Ingreso" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            </div>
                                            
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fecha_inicio" class=" form-control-label">Fecha de inicio de labores</label>
                                                	<input type="text" id="fecha_inicio" name="fecha_inicio" placeholder="Fecha Inicio de labores" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            		 <label for="puesto" class=" form-control-label">Puesto</label>
	                                                <select id="puesto" name="puesto" class="form-control">
														  <option value="">Seleccione el puesto</option>
														  <c:forEach items="${puestos}" var="p">
														  		<option value="${p.idPuesto}">${p.nombre}</option>
														  </c:forEach>
													</select> 
                                            	</div>
                                            </div>
                                           
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarEmpleado" type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Guardar
                                        </button>
                                        <button id="regresar" type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Regresar
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

<%@ include file = "../../include/footer.jsp" %>


<script>
$(document).ready(function() {
	
	
	 $('#regresar').click(function(){
		 document.location.href = 'listEmpleados'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker();
});


</script>