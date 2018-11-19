<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Actualizar</strong> Clientes
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="updateCliente" method="post" class="" id="formularioCliente">
                                        	<input value="${clientes.idCliente}" name="id" type="hidden">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="nombre" class=" form-control-label">Nombres</label>
                                                	<input type="text" id="nombres" name="nombres" placeholder="Nombres" class="form-control" value="${clientes.nombres}" required>
                                                </div>
                                                <div class="col-6">
                                                 	<label for="apellidos" class=" form-control-label">Apellidos</label>
                                                	<input type="text" id="apellidos" name="apellidos" placeholder="Apellidos" class="form-control" value="${clientes.apellidos}" required>
                                                </div>
                                            </div>
                                            
                                            
                                            <div class="row">

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
                                         	<label for="telefono" class=" form-control-label">Telefono</label>
                                         	<input type="text" id="telefono" name="telefono" placeholder="####-####"class="form-control" value="${clientes.telefono}"  required>
                                         </div>
                                          		<div class="col-6">
                                                	<label for="correo_electronico" class=" form-control-label">Correo Electronico</label>
                                                	<input type="text" id="correo_electronico" name="correo_electronico" placeholder="Correo Electronico" class="form-control" value="${clientes.corroeElectronico}" required>
                                                </div>
                                                
                                            </div>

                                            <div class="row">
                                            	
                                            	<div class="col-6">
                                            		<label for="fechaIngreso" class=" form-control-label">Fecha de ingreso</label>
                                                	<input type="text" id="fechaIngreso" name="fechaIngreso" placeholder="Fecha Ingreso" value="<fmt:formatDate value='${clientes.fechaIngreso}' pattern='dd/MM/yyyy' />" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                                <div class="col-6">
                                             	<label for="nit" class=" form-control-label">Nit</label>
                                            	<input type="text" id="nit" name="nit" placeholder="Nit" class="form-control" value="${clientes.nit}" required>
                                            </div>
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

<%@ include file = "../../include/footer.jsp" %>


<script>
$(document).ready(function() {
	
	var genero ="${cliente.genero}";
	console.log(typeof(genero));
	if (genero == 'true')
		{
		$("#genero1").prop("checked", true);
		}
	else{
		$("#genero2").prop("checked", true);
	}
	
	
	
	
	 $('#regresar').click(function(){
		 document.location.href = 'listClientes'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker({ dateFormat: 'dd/mm/yyyy' });
});


</script>