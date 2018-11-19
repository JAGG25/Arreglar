<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					
<%@ include file = "../../../include/header.jsp" %>

					<div class="row rowAjuste">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Puestos</h3>
                                <div class="table-data__tool">
                                   
                                    <div class="table-data__tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small" id="crear">
                                            <i class="zmdi zmdi-plus"></i>Agregar</button>
                                       
                                    </div>
                                </div>
                                <div class="table table-responsive">
                                <c:if test="${not empty puestos}">
                                    <table class="table table-striped table-bordered nowrap" id="table">
                                        <thead>
                                            <tr>
                                              
                                                <th>Nombre</th>
                                                
                                               
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${puestos}" var="p">
    										<tr class="tr-shadow">
                                                <td>
                                                    ${p.nombre}
                                                </td>
                                                
                                               
                                                <td>
                                                    <div class="table-data-feature">
                                                        <form action="updatePuesto" method="get" id="formUpdate-${p.idPuesto}">
                                                        <input type ="hidden" id="update-${p.idPuesto}" value="${p.idPuesto}" name="id"/>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Editar" onclick="updatePuesto('${p.idPuesto}')">
                                                            <i class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        </form>
                                                        
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="Eliminar" onclick="eliminarPuesto('${p.idPuesto}')">
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
                      
                      

<%@ include file = "../../../include/footer.jsp" %>

  <script>
  				$(document).ready(function() {
                        	
                       	 $('#crear').click(function(){
                       		 document.location.href = 'addPuesto'
                    			}); 
                    	}); 
  						
  				function eliminarPuesto(id)
  		     	{
  		     		console.log(id);
  		     		url="eliminarPuesto"
  		     		 $.ajax({                        
  			    		    type: "POST",                 
  			    		    url: url,                     
  			    		    data:{id: id},
  			    		    success: function(data)             
  			    	           {
  			    		    	if (data=="success")
  			    		    		{
  			    		    		alert("Puesto eliminado");
  			    		    		document.location.href = 'listPuestos'
  			    		    		}
  			    		    		
  			    	           }
  			    		   });
  		     	}
  		     	function updatePuesto(id)
  		     	{
  		     		console.log(id);
  		     	 
  		    		 $("#formUpdate-"+id).submit();
  		 		
  		     	}
  				 
                        </script>