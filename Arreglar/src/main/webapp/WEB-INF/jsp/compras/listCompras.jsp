<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Compras</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                <c:if test="${not empty compras}">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              	<th>Id Compra</th>
                                                <th>No Orden Compra</th>
                                            	<th>Id Proveedor</th>
                                                <th>Fecha Orden</th>
                                                <th>Fecha Ingreso</th>
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${compras}" var="c">
    										<tr class="tr-shadow">
                                                <td>
                                                	
                                                    ${c.idcompra}
                                                  
                                                </td>
                                                 <td>
                                                    ${c.no_orden_compra}
                                                </td>
                                                 
                                                <td>
                                                ${c.idproveedore}
                                            </td>
                                            
                                            <td>
                                            <fmt:formatDate value='${c.fechaOrden}' pattern='dd/MM/yyyy' />
                                        </td>
                                        
                                        <td>
                                        <fmt:formatDate value='${c.fechaIngreso}' pattern='dd/MM/yyyy' />
                                    </td>
                                            
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateCompras" method="get" id="formUpdate-${c.idcompra}">
                                                        <input type ="hidden" id="update-${c.idcompra}" value="${c.idcompra}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateCompras('${c.idcompra}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarCompras('${c.idcompra}')">
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
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                      
                      

<%@ include file = "../include/footer.jsp" %>

<script>
	$(document).ready(function() {
        	
       	 $('#crear').click(function(){
       		 document.location.href = 'addCompras'
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
	
			
	function eliminarCompras(id)
	{
		console.log(id);
		url="eliminarCompras"
		 $.ajax({                        
  		    type: "POST",                 
  		    url: url,                     
  		    data:{id: id},
  		    success: function(data)             
  	           {
  		    	if (data=="success")
  		    		{
  		    		alert("Compras eliminado");
  		    		document.location.href = 'listCompras'
  		    		}
  		    		
  	           }
  		   });
	}
	function updateCompras(id)
	{
		console.log(id);
	 
		 $("#formUpdate-"+id).submit();
	
	}
	 
        </script>