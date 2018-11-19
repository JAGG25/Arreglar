<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../../include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Marcas</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table-responsive table-responsive-data2">
                                <c:if test="${not empty marcas}">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              	<th>Id Marcas</th>
                                                <th>Marcas</th>
                                                
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${marcas}" var="m">
    										<tr class="tr-shadow">
                                                <td>
                                                	
                                                    ${m.idmarcas}
                                                  
                                                </td>
                                                 <td>
                                                    ${m.marcas}
                                                </td>
                                                 
                                            
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updateMarcas" method="get" id="formUpdate-${m.idmarcas}">
                                                        <input type ="hidden" id="update-${m.idmarcas}" value="${m.idmarcas}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updateMarcas('${m.idmarcas}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarMarcas('${m.idmarcas}')">
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
                       		 document.location.href = '/productos/marcas/addMarcas'
                    			}); 
                    	}); 
  						
  				function eliminarMarcas(id)
  		     	{
  		     		console.log(id);
  		     		url="/productos/marcas/eliminarMarcas"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Marca eliminada");
  			    		    		document.location.href = '/productos/marcas/listMarcas'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updateMarcas(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>