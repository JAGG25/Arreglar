<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %>

           		 <div style="height: 80%" class="row">
                            <div class="col-md-12">
                                 <div class="card">
                                    <div class="card-header">
                                        <strong>Información </strong> Cuenta
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="cambioContra" method="post" class="" id="cambioContra">
                                            <input name="idEmpleado" id="idEmpleado" value="${user.id}" type="hidden" />
                                             <div class="form-group">
			                                    <label>Nombres</label>
			                                    <input class="au-input au-input--full" type="text" name="name"  value="${user.name}">
			                                </div>
			                                <div class="form-group">
			                                    <label>Apellidos</label>
			                                    <input class="au-input au-input--full" type="text" name="lastName" value="${user.lastName}">
			                                </div>
			                                <div class="form-group">
			                                    <label>Correo Electrónico</label>
			                                    <input class="au-input au-input--full" type="email" name="email" placeholder="demo@correo.com" value="${user.email}">
			                                </div>
                                            <div class="form-group">
                                                <label for="antigua" class=" form-control-label">Antigua Contraseña</label>
                                                <input type="password" id="antigua" name="antigua" placeholder="Antigua Contraseña" class="form-control" autocomplete="off" >
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="nueva" class=" form-control-label">Nueva Contraseña</label>
                                                <input type="password" id="password" name="password" placeholder="Nueva Contraseña" class="form-control" >
                                                
                                            </div>
                                            <div class="form-group">
                                                <label for="confirmar" class=" form-control-label">Confirmar Contraseña</label>
                                                <input type="password" id="password2" name="password2" placeholder="Confirmar Contraseña" class="form-control">
                                                
                                            </div>
                                          
                                        </form>
                                    </div>
                                    <div class="card-footer">
                                        <button id="cambiarContraseña" type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Guardar
                                        </button>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
					
<%@ include file = "include/footer.jsp" %>