<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar</strong> Compras
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="addCompras" method="post" class="" id="formularioCompras">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="no_orden_compra" class=" form-control-label">No Orden Compra</label>
                                                	<input type="text" id="no_orden_compra" name="no_orden_compra" placeholder="no_orden_compra" class="form-control" required>
                                                </div>
                                                <div class="col-6">
                                                <label for="proveedores" class=" form-control-label">Proveedores</label>
                                                <select id="proveedores" name="proveedores" class="form-control">
													  <option value="">Seleccione el Proveedor</option>
													  <c:forEach items="${proveedores}" var="p">
													  		<option value="${p.idProveedore}">${p.proveedor}</option>
													  </c:forEach>
												</select> 
                                                </div>
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
                                                	<label for="fechaOrden" class=" form-control-label">Fecha de orden</label>
                                                	<input type="text" id="fechaOrden" name="fechaOrden" placeholder="fechaOrden" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
                                            	<div class="col-6">
                                            		<label for="fecha_ingreso" class=" form-control-label">Fecha de ingreso</label>
                                                	<input type="text" id="fecha_ingreso" name="fecha_ingreso" placeholder="Fecha Ingreso" class="form-control datepicker" data-date-format="dd/mm/yyyy" required>
                                            	</div>
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
                                        <button id="guardarCompras" type="submit" class="btn btn-primary btn-sm">
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
		 document.location.href = 'listCompras'
		}); 

	});
		
$(function () {
    $('.datepicker').datepicker();
});


</script>