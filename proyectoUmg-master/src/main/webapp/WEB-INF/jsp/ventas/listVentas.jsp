<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Ventas</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table table-responsive">
                                <c:if test="${not empty ventas}">
                                    <table class="table table-striped table-bordered nowrap" style="width:100%" id="table">
                                        <thead>
                                            <tr>
                                              	<th>Id</th>
                                                <th>No Factura</th>
                                                <th>Serie</th>
                                                <th>Fecha Factura</th>
                                                <th>Fecha de Ingreso</th>
                                                <th>Clientes</th>
                                                <th>Empleados</th>
                                                
                                                
                                               
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                        	<c:forEach items="${ventas}" var="v">
    										<tr class="tr-shadow">
    											 <td>
                   
                                                    ${v.idVenta}

                
                                                </td>
                                                <td>
                                                    ${v.noFactura}
                                                </td>
                                                <td>
                                                    ${v.serie}
                                                </td>
                                                <td>
                                                ${v.cliente.nombres}	
                                                </td>
                                              
                                                <td>
                                                ${v.emppleado.nombres}
                                                </td>
                                            
                                                <td>
                                                <td>
                                                    <fmt:formatDate value='${v.fechaFactura}' pattern='dd/MM/yyyy' />
                                                </td>
                                                <td>
                                                    <fmt:formatDate value='${v.fechaIngreso}' pattern='dd/MM/yyyy' />
                                                </td>
                                                
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateVentas" method="get" id="formUpdate-${v.idVenta}">
                                                        <input type ="hidden" id="update-${v.idVenta}" value="${v.idVenta}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateVentas('${v.idVenta}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarVentas('${v.idVenta}')">
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
                      
                      

<%@ include file = "../include/footer.jsp" %>

  <script>
  				$(document).ready(function() {
                        	
                       	 $('#crear').click(function(){
                       		 document.location.href = 'addVentas'
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
  				
  						
  				function eliminarVentas(id)
  		     	{
  		     		console.log(id);
  		     		url="/ventas/eliminarVentas"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Ventas eliminada");
  			    		    		document.location.href = 'listVentas'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateVentas(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>