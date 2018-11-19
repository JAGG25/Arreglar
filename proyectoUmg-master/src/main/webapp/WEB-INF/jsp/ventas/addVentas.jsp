0<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar</strong> Ventas
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="addVentas" method="post" class="" id="formularioVentas">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="noFactura" class=" form-control-label">No de Facturas</label>
                                                	<input type="text" id="noFactura" name="noFactura" placeholder="noFactura" class="form-control" required>
                                                </div>
                                            </div>
                                            <div class="row">
                                        	<div class="col-6">
                                            	<label for="serie" class=" form-control-label">Serie de Factura</label>
                                            	<input type="text" id="serie" name="serie" placeholder="Serie" class="form-control" required>
                                            </div>
                                            </div>

                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fechaFactura" class=" form-control-label">Fecha de Factura</label>
                                                	<input type="text" id="fechaFactura" name="fechaFactura" placeholder="Fecha Factura" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            	<label for="empleado" class=" form-control-label">Empleado</label>
                                            	 <select id="empleado" name="empleado" class="form-control">
                                            	 <option value="">Seleccione el Empleado</option>
                                            	 <c:forEach items="${Empleados}" var="e">
                                            	 <option value="${e.id}">${e.nombres} ${e.apellidos}</option>
                                            	 </c:forEach>
            									 </select> 
            									 </div>
                                            </div>
                                            
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fechaIngreso" class=" form-control-label">Fecha de ingreso</label>
                                                	<input type="text" id="fechaIngreso" name="fechaIngreso" placeholder="Fecha Ingreso" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            	<label for="clientes" class=" form-control-label">Cliente</label>
                                            	 <select id="clientes" name="clientes" class="form-control">
                                            	 <option value="">Seleccione el Cliente</option>
                                            	 <c:forEach items="${cliente}" var="c">
                                            	 <option value="${c.idCliente}">${c.nombres} ${c.apellidos}</option>
                                            	 </c:forEach>
            									 </select> 
            									 </div>
                                            </div>
                                           
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarVentas" type="submit" class="btn btn-primary btn-sm">
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
		 document.location.href = 'listVentas'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker();
});


</script>