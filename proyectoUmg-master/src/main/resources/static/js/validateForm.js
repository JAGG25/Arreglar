jQuery(function($){
//	$.getScript("/js/jquery.validate.min.js",function(){
				$(document).ready(function(){
					
					var msgRequiredGeneric = "Este campo es requerido";
					var msgMaxlength = "Cantidad de caracteres no permitidos";
					var msgRequiredEmail = "Debe ingresar un correo válido";
					var msgRequiredNumber = "Deben ser numeros";
					var msgAccept = "Formato de archivo no válido";
					var msgPhone = "Número de teléfono no válido";
					var msgMaxlengthNumber = $.validator.format("Ingrese un máximo de {0} números");
					var msgMinlengthNumber = $.validator.format("Ingrese al menos {0} números");
					var msgNumber = "Número no válido";
					var msgFecha = "La fecha debe final ser mayor a la inicial"
					var msgPassword = "Las contraseñas deben ser iguales";
					
//		======================= ALERTAS FORMULARIO PUESTO ============================================
						
					$("input[name], select[name], span.fancyFiled", "#formularioPuesto").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO EMPLEADO ============================================
					
					$("input[name], select[name], span.fancyFiled", "#formularioEmpleado").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO PRODUCTOS ============================================
					
					$("input[name], select[name], span.fancyFiled", "#formularioProductos").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//					======================= ALERTAS FORMULARIO CLIENTES ============================================
						
						$("input[name], select[name], span.fancyFiled", "#formularioCliente").tooltipster({ 
							trigger: 'custom', // default is 'hover' which is no good here
							onlyOne: false,    // allow multiple tips to be open at a time
							position: 'right'  // display the tips to the right of the element
					    });
						
//						======================= ALERTAS FORMULARIO COMPRAS ============================================
						
						$("input[name], select[name], span.fancyFiled", "#formularioCompras").tooltipster({ 
							trigger: 'custom', // default is 'hover' which is no good here
							onlyOne: false,    // allow multiple tips to be open at a time
							position: 'right'  // display the tips to the right of the element
					    });
						
					
						
//					======================= ALERTAS FORMULARIO PROVEEDORES ============================================
						
						$("input[name], select[name], span.fancyFiled", "#formularioProveedores").tooltipster({ 
							trigger: 'custom', // default is 'hover' which is no good here
							onlyOne: false,    // allow multiple tips to be open at a time
							position: 'right'  // display the tips to the right of the element
					    });
						
//						======================= ALERTAS FORMULARIO VENTAS ============================================
						
						$("input[name], select[name], span.fancyFiled", "#formularioVentas").tooltipster({ 
							trigger: 'custom', // default is 'hover' which is no good here
							onlyOne: false,    // allow multiple tips to be open at a time
							position: 'right'  // display the tips to the right of the element
					    });
						
						
						
//		======================= ALERTAS FORMULARIO USUARIO ============================================
					
					$("input[name], select[name], span.fancyFiled", "#registroUsuario").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					
//		======================= ALERTAS FORMULARIO LOGIN ============================================
					
					$("input[name], select[name], span.fancyFiled", "#loginForm").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO CAMBIO CONTRA ============================================
					
					$("input[name], select[name], span.fancyFiled", "#cambioContra").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
//		======================= ALERTAS FORMULARIO CAMBIO CONTRA ============================================
					
					$("input[name], select[name], span.fancyFiled", "#formularioMarcas").tooltipster({ 
						trigger: 'custom', // default is 'hover' which is no good here
						onlyOne: false,    // allow multiple tips to be open at a time
						position: 'right'  // display the tips to the right of the element
				    });
					
					
					$.validator.addMethod("phoneNumber", function(value, element){
						return this.optional(element) || /^[0-9]{4,4}-[0-9]{4,4}$/.test(value);
					});
					
					$.validator.addMethod("greaterStart", function (value, element, params) {
					    return this.optional(element) || $(element).val() >= $(params).val();
					});
					
//	======================= VALIDACIONES FORMULARIO USUARIO ============================================
					
					$("#registroUsuario").validate({
						rules : {
							name : {
								required : true,
							},
							lastName : {
								required : true,
							},
							email : {
								required : true,
								email: true
							},
							password : {
								required : true,
							},
							password2 : {
								required : true,
								equalTo: "#password"
							},
							
						},
						messages : {
							name : {
								required : msgRequiredGeneric,
							},
							lastName : {
								required : msgRequiredGeneric,
							},
							email : {
								required : msgRequiredGeneric,
								email: msgRequiredEmail
							},
							password : {
								required : msgRequiredGeneric,
							},
							password2 : {
								required : msgRequiredGeneric,
								equalTo: msgPassword
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				   
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	else if (isInputFile) {
				        		
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});

//					======================= VALIDACIONES FORMULARIO CAMBIO CONTRA ============================================	
					
					
					$("#cambioContra").validate({
						rules : {
							name : {
								required : true,
							},
							lastName : {
								required : true,
							},
							email : {
								required : true,
								email: true
							},
							password : {
								required :  function(element){
						            return $("#antigua").val().length > 0;
						        }
,
							},
							password2 : {
								required :  function(element){
						            return $("#password").val().length > 0;
						        },
								equalTo: "#password"
							},
							
						},
						messages : {
							name : {
								required : msgRequiredGeneric,
							},
							lastName : {
								required : msgRequiredGeneric,
							},
							email : {
								required : msgRequiredGeneric,
								email: msgRequiredEmail
							},
							password : {
								required : msgRequiredGeneric,
							},
							password2 : {
								required : msgRequiredGeneric,
								equalTo: msgPassword
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#cambioContra").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#cambioContra").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				   
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	else if (isInputFile) {
				        		
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//	======================= VALIDACIONES FORMULARIO LOGIN ============================================					
					
					$("#loginForm").validate({
						rules : {
							email : {
								required : true,
								email: true,
							},
							password : {
								required : true,
							},
							
						},
						messages : {
							email : {
								required : msgRequiredGeneric,
								email: msgRequiredEmail
							},
							password : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//	======================= VALIDACIONES FORMULARIO PUESTO ============================================					
					
					$("#formularioPuesto").validate({
						rules : {
							nombre : {
								required : true,
							},
							
						},
						messages : {
							nombre : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});

					
//	======================= VALIDACIONES FORMULARIO MARCAS ============================================					
					
					$("#formularioMarcas").validate({
						rules : {
							marca : {
								required : true,
							},
							
						},
						messages : {
							marca : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioMarcas").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioMarcas").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
//			======================= VALIDACIONES FORMULARIO PROVEEDORES ============================================
					
					
					$("#formularioProveedores").validate({
						rules : {
							proveedor : {
								required : true,
							},
							nit : {
								required : true,
							},
							direccion : {
								required : true,
							},
							telefono : {
								required : true,
								phoneNumber: true,
							},
							
						},
						messages : {
							proveedor : {
								required : msgRequiredGeneric,
							},
							nit : {
								required : msgRequiredGeneric,
							},
							direccion : {
								required : msgRequiredGeneric,
							},
							telefono : {
								required : msgRequiredGeneric,
								phoneNumber: msgPhone,
							},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioProveedores").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioProveedores").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//	======================= VALIDACIONES FORMULARIO PRODUCTOS ============================================					
					
					$("#formularioProductos").validate({
						rules : {
							productos : {
								required : true,
							},
							imagen : {
								required : true,
							},
							precio_costo : {
								required : true,
							},
							precio_venta : {
								required : true,
							},
							existencia : {
								required : true,
							},
							fecha_ingreso : {
								required : true,
							},
							marcas : {
								required : true,
							},
						
						},
						messages : {
							productos : {
								required : msgRequiredGeneric,
							},
							imagen : {
								required : msgRequiredGeneric,
							},
							precio_costo : {
								required : msgRequiredGeneric,
							},
							precio_venta : {
								required : msgRequiredGeneric,
							},
							existencia : {
								required : msgRequiredGeneric,
							},
							fecha_ingreso : {
								required : msgRequiredGeneric,
							},
							marcas : {
								required : msgRequiredGeneric,
							},
						},
							errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioProductos").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioProductos").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//			======================= VALIDACIONES FORMULARIO VENTAS ============================================
					
					
					$("#formularioVentas").validate({
						rules : {
							noFactura : {
								required : true,
							},
							serie : {
								required : true,
							},
							fechaFactura : {
								required : true,
							},
							fechaIngreso : {
								required : true,
							},
							
						},
						messages : {
							noFactura : {
								required : msgRequiredGeneric,
							},
							serie : {
								required : msgRequiredGeneric,
							},
							fechaFactura : {
								required : msgRequiredGeneric,
							},
							fechaIngreso : {
								required : msgRequiredGeneric,
							},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioVentas").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioVentas").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					

					
//			======================= VALIDACIONES FORMULARIO EMPLEADO ============================================
					
					
					$("#formularioEmpleado").validate({
						rules : {
							nombres : {
								required : true,
							},
							apellidos : {
								required : true,
							},
							direccion : {
								required : true,
							},
							telefono : {
								required : true,
								phoneNumber: true,
							},
							dpi : {
								required : true,
							},
							genero : {
								required : true,
							},
							fecha_nacimiento : {
								required : true,
							},
							fecha_ingreso : {
								required : true,
							},
							fecha_inicio : {
								required : true,
							},
							puesto : {
								required : true,
							},
							
							
						},
						messages : {
							nombres : {
								required : msgRequiredGeneric,
							},
							apellidos : {
								required : msgRequiredGeneric,
							},
							direccion : {
								required : msgRequiredGeneric,
							},
							telefono : {
								required : msgRequiredGeneric,
								phoneNumber: msgPhone,
							},
							dpi : {
								required : msgRequiredGeneric,
							},
							genero : {
								required : msgRequiredGeneric,
							},
							fecha_nacimiento : {
								required : msgRequiredGeneric,
							},
							fecha_ingreso : {
								required : msgRequiredGeneric,
							},
							fecha_inicio : {
								required : msgRequiredGeneric,
							},
							puesto : {
								required : msgRequiredGeneric,
							},
							
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioPuesto").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
//			======================= VALIDACIONES FORMULARIO COMPRAS ============================================
					
					
					$("#formularioCompras").validate({
						rules : {
							no_orden_compra : {
								required : true,
							},
							idproveedore : {
								required : true,
							},
							fechaOrden : {
								required : true,
							},
							fechaIngreso : {
								required : true,
							},
							
						},
						messages : {
							no_orden_compra : {
								required : msgRequiredGeneric,
							},
							idproveedore : {
								required : msgRequiredGeneric,
							},
							fechaOrden : {
								required : msgRequiredGeneric,
							},
							fechaIngreso : {
								required : msgRequiredGeneric,
							},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCompras").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCompras").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
					});
					
					
					
					
					
//			======================= VALIDACIONES FORMULARIO CLIENTE ============================================
	
					$("#formularioCliente").validate({
						rules : {
							nombres : {
								required : true,
							},
							apellidos : {
								required : true,
							},
							nit : {
								required : true,
							},
							genero : {
								required : true,
							},
							telefono : {
								required : true,
								phoneNumber: true,
							},
							correo_electronico : {
								required : true,
							},
							fechaIngreso : {
								required : true,		
						},
						messages : {
							nombres : {
								required : msgRequiredGeneric,
							},
							apellidos : {
								required : msgRequiredGeneric,
							},
							nit : {
								required : msgRequiredGeneric,
							},
							genero : {
								required : msgRequiredGeneric,
							},
							telefono : {
								required : msgRequiredGeneric,
								phoneNumber: msgPhone,
							},
							correo_electronico : {
								required : msgRequiredGeneric,
							},
							
							fechaIngreso : {
								required : msgRequiredGeneric,
							},
							
						},
						errorPlacement: function (error, element) {
							if($(element).is("select")){
								$(element).addClass("is-invalid");
							}
							var isInputFile = $(element).is("input[type='file']");
							if (isInputFile) {
								$(element).addClass("is-invalid");
							}
							var isInput = $(element).is("input[type='text']");
							if (isInput) {
								$(element).addClass("is-invalid");
							}
							var lastError = $(element).data("lastError"),
			                newError = $(error).text();
	
				            $(element).data("lastError", newError);
		
				            if(newError !== "" && newError !== lastError){
				            	if (isInputFile) {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	} else {
				            		$(element).tooltipster("content", newError);
					                $(element).tooltipster("enable");
					                $(element).tooltipster("show");
				            	}
				            	
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCliente").focus(function(){
									$(this).tooltipster("show");
								});
				                
				                $("input[name].error, select[name].error, span.fancyFiled", "#formularioCliente").blur(function(){
									$(this).tooltipster("hide");
								});
				            }
				        },
				        success: function (label, element) {
				        	var isInputFile = $(element).is("input[type='file']");
				        	if($(element).is("select")){
								$(element).removeClass("is-invalid");
								$(element).tooltipster("disable");
							}
				        	if (isInputFile) {
								$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
							}
				        	else{
				        		$(element).removeClass("is-invalid");
								$(element).tooltipster("hide");
						        $(element).tooltipster("disable");
				        	} 
				            $(element).tooltipster("hide");
				            $(element).tooltipster("disable");
				        }
						}
					});
					
					
//		================= GUARDAR PUESTO =================== CLICK BOTON ===================			
					
					$("#guardarPuesto").click(function(){
						var formulario = $("#formularioPuesto");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					
//		================= GUARDAR EMPLEADO =================== CLICK BOTON ===================		
					
					$("#guardarEmpleado").click(function(){
						var formulario = $("#formularioEmpleado");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					
//		================= GUARDAR VENTAS =================== CLICK BOTON ===================			
					
					$("#guardarVentas").click(function(){
						var formulario = $("#formularioVentas");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					

//	   ================= GUARDAR USUARIO =================== CLICK BOTON ===================		
					
					$("#guardarUsuario").click(function(){
						var formulario = $("#registroUsuario");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
				
//		   ================= GUARDAR lOGIN =================== CLICK BOTON ===================		
				
					$("#iniciarSesion").click(function(){
						var formulario = $("#loginForm");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
//					   ================= GUARDAR MARCAS =================== CLICK BOTON ===================		
					
					$("#guardarMarca").click(function(){
						var formulario = $("#formularioMarcas");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						
						}
					});
					
//		================= GUARDAR PRODUCTOS =================== CLICK BOTON ===================			
					
					$("#guardarProductos").click(function(){
						var formulario = $("#formularioProductos");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					

//		================= GUARDAR PROVEEDORES =================== CLICK BOTON ===================		
					
					$("#guardarProveedores").click(function(){
						var formulario = $("#formularioProveedores");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					
					
//		================= GUARDAR CLIENTE =================== CLICK BOTON ===================		
					
					$("#guardarCliente").click(function(){
						var formulario = $("#formularioCliente");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
					
//		================= GUARDAR COMPRAS =================== CLICK BOTON ===================			
					
					$("#guardarCompras").click(function(){
						var formulario = $("#formularioCompras");
						if($(formulario).valid()){
							$(formulario).submit();
						}else{
							return false;
						}
					});
					
				
//					   ================= GUARDAR lOGIN =================== CLICK BOTON ===================		
					
					$("#cambiarContraseña").click(function(){
						var formulario = $("#cambioContra");
						var antigua = $("#antigua").val();
						var id = $("#idEmpleado").val();
						console.log(id);
						if (antigua.length != 0)
							{
							url="/validarContra"
					     		 $.ajax({                        
						    		    type: "POST",                 
						    		    url: url,                     
						    		    data:{antigua: antigua, id: id},
						    		    success: function(data)             
						    	           {
						    		    	if (data=="000")
						    		    		{
						    		    		alert("La contraseña no coincide con la registrada");
						    		    		return false;
						    		    		}
						    		    	else{
						    		    		if($(formulario).valid()){
						    		    			console.log("valido")
													$(formulario).submit();
												}else{
													return false;
												}
						    		    	}
						    	           }
						    		   });
							
							}
						else{
							console.log("sin cambio");
							if($(formulario).valid()){
								$(formulario).submit();
							}else{
								return false;
							}
						}
						
						
					});
					
				
//		});
	});
});
