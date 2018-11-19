<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar</strong> Proveedores
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="addProveedores" method="post" class="" id="formularioProveedores">
                                            <div class="form-group">
                                                <label for="proveedor" class=" form-control-label">Proveedor</label>
                                                <input type="text" id="proveedor" name="proveedor" placeholder="Nombre del Proveedor" class="form-control" required>    
                                            </div>
        
                                                    <div class="col-6">
                                                     	<label for="nit" class=" form-control-label">Nit</label>
                                                    	<input type="text" id="nit" name="nit" placeholder="Nit" class="form-control" required>
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