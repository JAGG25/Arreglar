<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Actualizar</strong> Proveedores
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="updateProveedores" method="post" class="" id="formularioProveedores">
                                        	<input value="${proveedores.idProveedore}" name="id" type="hidden">
                                            <div class="row">
                                            	<div class="col-6">
                                                	<label for="proveedor" class=" form-control-label">Proveedor</label>
                                                	<input type="text" id="proveedor" name="proveedor" placeholder="proveedor" class="form-control" value="${proveedores.proveedor}" required>
                                                </div>
                                                <div class="col-6">
                                                 	<label for="nit" class=" form-control-label">Nit</label>
                                                	<input type="text" id="nit" name="nit" placeholder="nit" class="form-control" value="${proveedores.nit}" required>
                                                </div>
                                            </div>
                                            
                                            <div class="row">
                                            	<div class="col-6">
                                            		<label for="direccion" class=" form-control-label">Dirección</label>
                                                	<input type="text" id="direccion" name="direccion" placeholder="Dirección" value="${proveedores.direccion}" class="form-control" required>
                                                </div>
                                             
                                                <div class="col-6">
                                                	<label for="telefono" class=" form-control-label">Telefono</label>
                                                	<input type="text" id="telefono" name="telefono" placeholder="####-####" value="${proveedores.telefono}" class="form-control" required>
                                                </div>
                                            </div>
	                                                        
	                                                    </div>
                                            </div>
                                           
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarProveedores" type="submit" class="btn btn-primary btn-sm">
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
		 document.location.href = 'listProveedores'
		}); 

	});
</script>