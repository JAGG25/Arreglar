<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Actualizar</strong> Ventas
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="updateVentas" method="post" class="" id="formularioVentas">
                                        	<input value="${ventas.id}" name="id" type="hidden">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="noFactura" class=" form-control-label">No de Facturas</label>
                                                	<input type="text" id="noFactura" name="noFactura" placeholder="noFactura" class="form-control" value="${ventas.noFactura}" required>
                                                </div>
                                                <div class="col-6">
                                                 	<label for="serie" class=" form-control-label">Serie</label>
                                                	<input type="text" id="serie" name="serie" placeholder="serie" class="form-control" value="${ventas.serie}" required>
                                                </div>
                                            </div>
	                                             </div>
                                            </div>

                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="fechaFactura" class=" form-control-label">Fecha de factura</label>
                                                	<input type="text" id="fechaFactura" name="fechaFactura" placeholder="fechaFactura" value="<fmt:formatDate value='${ventas.fechaFactura}' pattern='dd/MM/yyyy' />" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            		<label for="fechaIngreso" class=" form-control-label">Fecha de ingreso</label>
                                                	<input type="text" id="fechaIngreso" name="fechaIngreso" placeholder="Fecha Ingreso" value="<fmt:formatDate value='${ventas.fechaIngreso}' pattern='dd/MM/yyyy' />" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                        </form>
                                        </div>
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
    $('.datepicker').datepicker({ dateFormat: 'dd/mm/yyyy' });
});


</script>