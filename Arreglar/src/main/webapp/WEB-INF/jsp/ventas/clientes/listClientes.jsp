<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Clientes</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                <c:if test="${not empty clientes}">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              	<th>Id Cliente</th>
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>NIT</th>
                                                <th>Genero</th>
                                                <th>Telefono</th>
                                                <th>Correo Electronico</th>
                                                <th>Fecha de Ingreso</th>
                                                
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${clientes}" var="c">
    										<tr class="tr-shadow">
                                                <td>
                                                	
                                                    ${c.idCliente}
                                                   
                                                </td>
                                                 <td>
                                                    ${c.nombres}
                                                </td>
                                                 <td>
                                                    ${c.apellidos}
                                                </td>
                                                 <td>
                                                    ${c.nit}
                                                </td>
                                                 <td>
                                                 	<c:if test="${c.genero == true}">
                                                 	Hombre
                                                 	</c:if>
                                                 	<c:if test="${c.genero == false}">
                                                 	Mujer
                                                 	</c:if>
                                                    
                                                </td>
                                                 <td>
                                                    ${c.telefono}
                                                </td>
                                                 <td>
                                                    ${c.corroeElectronico}
                                                </td>
                                                 <td>
                                                    ${c.fechaIngreso}
                                                </td>
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateCliente" method="get" id="formUpdate-${c.idCliente}">
                                                        <input type ="hidden" id="update-${c.idCliente}" value="${c.idCliente}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateCliente('${c.idCliente}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarCliente('${c.idCliente}')">
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
                      
                      

<%@ include file = "../../include/footer.jsp" %>

  <script>
  				$(document).ready(function() {
                        	
                       	 $('#crear').click(function(){
                       		 document.location.href = '/ventas/clientes/addClientes'
                    			}); 
                    	}); 
  						
  				function eliminarCliente(id)
  		     	{
  		     		console.log(id);
  		     		url="/ventas/clientes/eliminarCliente"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Empleado eliminado");
  			    		    		document.location.href = '/ventas/clientes/listClientes'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateCliente(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>