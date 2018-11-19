<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar Compras</strong> 
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
                                            
                                          	
                                           
                                          	<div class="row">
                                               
	                                           
	                                             <div class="col-6">
			                                      	<label for="precio_costo_unitario" class=" form-control-label">Precio Unitario del Producto</label>
			                                      	<input type="text" id="precio_costo_unitario" name="precio_costo_unitario" placeholder="Cantidad" class="form-control"required>	
			                                      	
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
                                            <div class ="row">
                                            	<div class="col-6">
                                            		 <label for="productos" class=" form-control-label">Productos</label>
	                                                <select id="productos" name="productos" class="form-control">
														  <option value="">Seleccione el producto</option>
														  <c:forEach items="${productos	}" var="p">
														  		<option value="${p.idProducto}">${p.producto}</option>
														  </c:forEach>
													</select> 
													   </div>

				                                     <div class="col-6">
				                                      	<label for="cantidad" class=" form-control-label">Cantidad de productos</label>
				                                      	<input type="text" id="cantidad" name="Cantidad" placeholder="cantidad" class="form-control"required>	
				                                      	
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