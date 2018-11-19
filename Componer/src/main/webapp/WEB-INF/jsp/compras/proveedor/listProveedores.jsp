<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Proveedores</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                <c:if test="${not empty proveedores}">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              	<th>Id Proveedores</th>
                                                <th>Proveedor</th>
                                            	<th>Nit</th>
                                                <th>direccion</th>
                                                <th>Telefono</th>
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${proveedores}" var="p">
    										<tr class="tr-shadow">
                                                <td>
                                                	
                                                    ${p.idProveedore}
                                                  
                                                </td>
                                                 <td>
                                                    ${p.proveedor}
                                                </td>
                                                 
                                                <td>
                                                ${p.nit}
                                            </td>
                                            
                                            <td>
                                            ${p.direccion}
                                        </td>
                                        
                                        <td>
                                        ${p.telefono}
                                    </td>
                                            
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateProveedores" method="get" id="formUpdate-${p.idProveedore}">
                                                        <input type ="hidden" id="update-${p.idProveedore}" value="${p.idProveedore}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateProveedores('${p.idProveedore}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarProveedores('${p.idProveedore}')">
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
                       		 document.location.href = 'addProveedores'
                    			}); 
                    	}); 
  						
  				function eliminarMarcas(id)
  		     	{
  		     		console.log(id);
  		     		url="eliminarProveedores"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Proveedor eliminado");
  			    		    		document.location.href = 'listProveedores'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateProveedores(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>