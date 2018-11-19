<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Empleados</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table table-responsive">
                                <c:if test="${not empty empleados}">
                                    <table class="table table-striped table-bordered nowrap" style="width:100%" id="table">
                                        <thead>
                                            <tr>
                                              	<th>Id</th>
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>Telefono</th>
                                                <th>Direccion</th>
                                                <th>dpi</th>
                                                <th>Genero</th>
                                                <th>Fecha Nacimiento</th>
                                                <th>Fecha Inicio de labores</th>
                                                <th>Fecha de Ingreso</th>
                                                <th>Puesto</th>
                                                
                                                
                                               
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                        	<c:forEach items="${empleados}" var="e">
    										<tr class="tr-shadow">
    											 <td>
                                                    <c:if test="${e.id < 10}">
                                                    E-00${e.id}
                                                    </c:if>
                                                    <c:if test="${e.id < 100 && e.id>9}">
                                                    E-0${e.id}
                                                    </c:if>
                                                </td>
                                                <td>
                                                    ${e.nombres}
                                                </td>
                                                <td>
                                                    ${e.apellidos}
                                                </td>
                                                <td>
                                                    ${e.telefono}
                                                </td>
                                                <td>
                                                    ${e.direccion}
                                                </td>
                                                <td>
                                                    ${e.dpi}
                                                </td>
                                                <td>
                                                	<c:if test="${e.genero == true}">
                                                 	Hombre
                                                 	</c:if>
                                                 	<c:if test="${e.genero == false}">
                                                 	Mujer
                                                 	</c:if>
                                                </td>
                                                <td>
                                                    <fmt:formatDate value='${e.fechaNacimiento}' pattern='dd/MM/yyyy' />
                                                </td>
                                                <td>
                                                    <fmt:formatDate value='${e.fechaInicio}' pattern='dd/MM/yyyy' />
                                                </td>
                                                <td>
                                                    <fmt:formatDate value='${e.fechaIngreso}' pattern='dd/MM/yyyy' />
                                                </td>
                                                <td>
                                                    ${e.puesto.nombre}
                                                </td>
                                                
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateEmpleado" method="get" id="formUpdate-${e.id}">
                                                        <input type ="hidden" id="update-${e.id}" value="${e.id}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateEmpleado('${e.id}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarEmpleado('${e.id}')">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </button>
                                                        
                                                    </div>
                                                </td>
                                           </tr>
											</c:forEach>
                                           
                                            
                                        </tbody>
                                    </table>
                                    </c:if>
                                </div>
                                <!-- END DATA TABLE table_info  -->
                            </div>
                        </div>
                      
                      

<%@ include file = "../../include/footer.jsp" %>

  <script>
  				$(document).ready(function() {
                        	
                       	 $('#crear').click(function(){
                       		 document.location.href = 'addEmpleado'
                    			}); 
                       	 
                       	 var table = $('#table').DataTable( {
                             responsive: true,
                             fixedColumns:   {
                                 rightColumns: 1
                             },
                             "language": {
                            	    "sProcessing":     "Procesando...",
                            	    "sLengthMenu":     "Mostrar _MENU_ registros",
                            	    "sZeroRecords":    "No se encontraron resultados",
                            	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
                            	    "sInfo":           "Resgistros _START_ al _END_  de  _TOTAL_",
                            	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
                            	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
                            	    "sInfoPostFix":    "",
                            	    "sSearch":         "Buscar:",
                            	    "sUrl":            "",
                            	    "sInfoThousands":  ",",
                            	    "sLoadingRecords": "Cargando...",
                            	    "oPaginate": {
                            	        "sFirst":    "Primero",
                            	        "sLast":     "Último",
                            	        "sNext":     "Siguiente",
                            	        "sPrevious": "Anterior"
                            	    },
                            	    "oAria": {
                            	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                            	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                            	    }
                            	},
                            
                         });
                    	}); 
  				
  						
  				function eliminarEmpleado(id)
  		     	{
  		     		console.log(id);
  		     		url="eliminarEmpleado"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Empleado eliminado");
  			    		    		document.location.href = 'listEmpleados'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateEmpleado(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>