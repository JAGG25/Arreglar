<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>

					<div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Estudiantes</h3>
                                
                                <div class="table-responsive table-responsive-data2">
                                    <table class="table table-data2">
                                        <thead>
                                            <tr>
                                              
                                                <th>No</th>
                                                <th>Nombre</th>
                                                <th>Carnet</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:forEach items="${estudiantes}" var="e">
    										<tr class="tr-shadow">
                                                <td>
                                                    ${e.id}
                                                </td>
                                                 <td>
                                                    ${e.nombre}
                                                </td>
                                                 <td>
                                                    ${e.carne}
                                                </td>
                                                
                                             
                                           </tr>
											</c:forEach>
                                           
                                            
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                            </div>
                        </div>
                      
					
<%@ include file = "include/footer.jsp" %>