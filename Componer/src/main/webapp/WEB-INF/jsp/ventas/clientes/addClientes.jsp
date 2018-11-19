<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
						<div style="height: 80%" class="row">
						 <div class="col-md-12">
                         <div class="card">
                         
                         		<div class="card-header">
                         			<strong>Agregar</strong> Cliente
                         		</div>
						
                         			<div class="card-body card-block">
                         			 <form action="addCliente" method="post" class="" id="formularioCliente">
                                     <div class="row"> 
                                     	<div class="col-6">
                                         	<label for="nombres" class=" form-control-label">Nombres</label>
                                         	<input type="text" id="nombres" name="nombres" placeholder="Nombres" class="form-control" required>
                                         </div>
                                         <div class="col-6">
                                          	<label for="apellidos" class=" form-control-label">Apellidos</label>
                                         	<input type="text" id="apellidos" name="apellidos" placeholder="Apellidos" class="form-control" required>
                                         </div>
                                     </div>
                         			  </div>
                         			  
                         			    <div class="row">
                                    	<div class="col-6">
                                    			<label for="nit " class=" form-control-label">NIT</label>
                                    			<input type="text" id="nit" name="nit" placeholder="Nit" class="form-control" required>
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
                                	<label for="correoElectronico" class=" form-control-label">Correo Electronico</label>
                                	<input type="text" id="correoElectronico" name="correoElectronico" placeholder="correo@hotmail.com" class="form-control " required>
                            	</div>
                            	

                                <div class="row">
                                <div class="col-6">
                            	<label for="telefono" class=" form-control-label">Telefono</label>
                            	<input type="text" id="telefono" name="telefono" placeholder="####-####" class="form-control " required>
                        	</div>
                                  
                                    </div>
                                    
                                    <div class="row">

                            		<div class="col-6">
                                                    		<label for="fechaIngreso" class=" form-control-label">Fecha de ingreso</label>
                                                        	<input type="text" id="fechaIngreso" name="fechaIngreso" placeholder="Fecha Ingreso" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                                        	</div>

                                    </div>
                                   
                                    
                                <div class="card-footer">
                                <button id="guardarCliente" type="submit" class="btn btn-primary btn-sm">
                                    <i class="fa fa-dot-circle-o"></i> Guardar
                                </button>
                                <button id="regresar" type="reset" class="btn btn-danger btn-sm">
                                    <i class="fa fa-ban"></i> Regresar
                                </button>
                            </div>
                                   
                         			
                  
						</div> 
						 </div>
                         </div>
                         </div>
<%@ include file = "../../include/footer.jsp" %>


<script>
$(document).ready(function() {
	
	
	 $('#regresar').click(function(){
		 document.location.href = 'listClientes'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker();
});


</script>