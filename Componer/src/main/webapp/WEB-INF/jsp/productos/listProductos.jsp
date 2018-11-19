<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Productos</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                <c:if test="${not empty productos}">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              	<th>Id Productos</th>
                                                <th>Productos</th>
                                            	<th>Id Marca</th>
                                                <th>Descripcion</th>
                                            	<th>Imagen</th>
                                                <th>Precio Costo</th>
                                            	<th>Precio Venta</th>
                                                <th>Existencia</th>
                                            	<th>Fecha Ingreso</th>
                                                
                                                
                                                
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${productos}" var="p">
    										<tr class="tr-shadow">
                                                <td>
                                                	
                                                    ${p.idProducto}
                                                  
                                                </td>
                                                 <td>
                                                    ${p.producto}
                                                </td>
                                                <td>
                                                ${p.marcas.marcas}
                                            </td>
                                            <td>
                                            ${p.descripcion}
                                        </td>
                                            <td>
                                            <img alt="imagen" src="data:image/jpeg;base64,${p.imagen}"  height="100" width="100" >
                                        </td>
                                        <td>
                                        ${p.precio_costo}
                                    </td>
                                    <td>
                                    ${p.precio_venta}
                                </td>
                                <td>
                                ${p.existencia}
                            </td>
                            <td>
                            <fmt:formatDate value='${p.fecha_ingreso}' pattern='dd/MM/yyyy' />
                        </td>
                                            
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateProductos" method="get" id="formUpdate-${p.idProducto}">
                                                        <input type ="hidden" id="update-${p.idProducto}" value="${p.idProducto}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateProductos('${p.idProducto}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarProductos('${p.idProducto}')">
                                                            <i class="zmdi zmdi-delete"></i>
                                                        </button>
                                                        
                                                    </div>
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
                       		 document.location.href = 'addProductos'
                    			}); 
                    	}); 
  						
  				function eliminarProductos(id)
  		     	{
  		     		console.log(id);
  		     		url="eliminarProductos"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Producto eliminado");
  			    		    		document.location.href = 'listProductos'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateProductos(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>