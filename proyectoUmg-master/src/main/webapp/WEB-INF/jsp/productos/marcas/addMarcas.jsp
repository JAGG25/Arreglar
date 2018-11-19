<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../../include/header.jsp" %>
					<div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Agregar</strong> Marcas
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="addMarcas" method="post" class="" id="formularioMarcas">
                                            <div class="form-group">
                                                <label for="nombre" class=" form-control-label">Nombre</label>
                                                <input type="text" id="marca" name="marca" placeholder="Nombre de la marca" class="form-control" required>
                                                
                                            </div>
                                          
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="guardarMarca" type="submit" class="btn btn-primary btn-sm">
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
		 document.location.href = 'listMarcas'
		}); 

	});
		



</script>