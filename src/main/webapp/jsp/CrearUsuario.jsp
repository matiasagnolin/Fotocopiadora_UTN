<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/styles.min.css">
    
<style type="text/css">
@media only screen and (max-device-width:540px) {
    	   .mobileLabel{
   text-align: left;
   }
   	 .mobilePad{
   margin-left: 4em;
   }
}
@media only screen and (max-device-width:750px) and
	(orientation:landscape) {
.mobileLabel{
   text-align: left;
   }
    .mobilePad{
   margin-left: 11%;
   }
	}
		.boxStyle{
margin-left: 20%;width: 60%;
}
</style>
 <style>
	.clase_principal {opacity:0.3;}
	.mostrar{display:inline;}
	.ocultar{display:none}
	.centrar
	{
		position: relative;
		/*nos posicionamos en el centro del navegador*/
		top:50%;
		left:50%;
		/*determinamos una anchura*/
		width:400px;
		/*indicamos que el margen izquierdo, es la mitad de la anchura*/
		margin-left:-200px;
		/*determinamos una altura*/
		height:300px;
		/*indicamos que el margen superior, es la mitad de la altura*/
		margin-top:-150px;

		padding:5px;
		display:inline;
		opacity:1;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 boxStyle" style="padding-right: 0px!important;padding-left: 0px!important;">
		   <div class="panel-body" style="padding-right: 4px!important;padding-left: 4px!important;">
                 
                 <form:form method="post" action="${pageContext.request.contextPath}/GuardarUsuario" name="form" id="form" modelAttribute="usuario">
				<fieldset class="landscape_nomargin" style="min-width: 0;padding:    .35em .625em .75em!important;margin:0 2px;border: 2px solid silver!important;margin-bottom: 10em;">
			<legend style="border-bottom: none;width: inherit;!important;padding:inherit;" class="legend">FORMULARIO DE CREACION DE USUARIO</legend>
		
			<div class="form-group">
						 <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12" style="text-align: right!important;">
						 <span style="color: red">*</span> <span style="font-size: 8pt;">CAMPOS OBLIGATORIOS</span>
						 </div>
						</div>	
			 <div class="form-group" style="margin-bottom: 0px;">
                    <div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message10" style=" font-size: 10pt;padding-left: 0px;"></div>                      

                    </div>				
		 <div class="form-group">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px; text-align: right;">
                            LEGAJO <span style="color: red">*</span> :</div>
                        
						<div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad" style="font-weight:600;">
						
						<form:input min="10000" value="-" type="number" style="border-radius: 4px!important;"  path="Nombre_Usuario" class="form-control" name="username" id="username" />                   
                                         
                        </div>
                       <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                    </div>
                    <div class="form-group">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px; text-align: right;">
                            NOMBRE <span style="color: red"></span> :</div>
                        
						<div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad" style="font-weight:600;">
						
						<form:input style="border-radius: 4px!important;" type="text"  path="Nombre_Persona" class="form-control"   />                   
                                         
                        </div>
                       <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                    </div>
                    <div class="form-group">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px; text-align: right;">
                            APELLIDO <span style="color: red"></span> :</div>
                        
						<div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad" style="font-weight:600;">
						
						<form:input style="border-radius: 4px!important;" type="text"  path="Apellido_Persona" class="form-control"  />                   
                                         
                        </div>
                       <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                    </div>
                    
         <div class="form-group">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px; text-align: right;">
                             Email <span style="color: red">*</span> :</div>
                        
						<div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad" style="font-weight:600;">
						
						<form:input path="Email_Persona" style="border-radius: 4px!important;" type="email"  class="form-control" name="yourEmail" id="yourEmail"/>                   
                                         
                        </div>
                       <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                    </div> 
                    
             
               
        <div class="form-group " style="margin-bottom: 5px;">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px;text-align: right;">
                           Password <span style="color: red">*</span> :</div>
                        
						<div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad">
						
						<form:input path="Password_Usuario" type="password" onkeyup="passwordChecker()" name="password" id="password" class="form-control"/>
						<span class="input-group-btn">
						<button class="btn btn-defaultCUST" id="view_button3" style=" height: 34px;padding-left: 7px;" type="button">
						<span class="glyphicon glyphicon-eye-open" >                   
                             </button></span>                    
                                      
                        </div>
                         <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        
                    </div>  
                    
                 <div class="form-group" style="margin-bottom: 5px;">
                    <div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message8" style=" font-size: 10pt;padding-left: 0px;"></div>                      

                    		 <div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message" style=" font-size: 10pt;"></div>
							<div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message2" style=" font-size: 10pt;"></div>
							<div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message3" style=" font-size: 10pt;"></div>
							<div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message4" style=" font-size: 10pt;"></div>
							<div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message5" style=" font-size: 10pt;"></div> 
							<div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message6" style=" font-size: 10pt;padding-left: 0px;"></div>
							<div class="col-sm-4 col-md-4 col-lg-5 col-xs-1"></div><div class="col-sm-8 col-md-8 col-lg-7 col-xs-10 mobilePad" id="message7" style=" font-size: 10pt;padding-left: 0px;"></div>                      
       
                    </div>
                  <div class="form-group">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px;text-align: right;">
                          Confirmar  Password <span style="color: red">*</span> :</div>
                        
						<div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad">
						
						<input type="password" name="verifypassword" id="verifypassword" class="form-control"><span class="input-group-btn"><button class="btn btn-defaultCUST" id="view_button4" style=" height: 34px;padding-left: 7px;" type="button"><span class="glyphicon glyphicon-eye-open"></span>                  
                             </button></span>                     
                                         
                        </div>
                       <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                    </div>	
                    <div class="form-group">
                    <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px;text-align: right;">
                          ELEGIR MATERIA <span style="color: red">*</span> :</div>
						<form:select class="" id="Carreras" path="carrera" name="Carreras"> <!-- SELECT DE CARRERAS, LO TENES QUE USAR. LE MANDO LAS CARRERAS DESDE EL CONTROLLER -->
								<form:option value="0" label="--- Elegir Carrera ---" />
						<c:forEach items="${carreras}" var="Carrera">
						        <form:option value="${Carrera.getId_Carrera()}">${Carrera.getDescripcion()}</form:option>
						</c:forEach>
						</form:select>
						
						<c:forEach items="${carreras}" var="Carrera">
						<form:select  class="ocultar " id="${Carrera.getId_Carrera()}Carrera"  path="materias" name="Materias"> <!--ES TE ES EL DE MATERIAS LE TENES QUE AGREGAR LA PROPIEDAD MULTIPLE PARA PODER ELEGIR VARIAS CON LA TECLA CONTROL APRETADA -->
								<form:option value="0" label="--- Elegir Materia ---" />
						<c:forEach items="${Carrera.getMaterias()}" var="Materia">  <!--TOMA LAS MATERIAS DEL OBJECTO MATERIAS -->
						        <form:option value="${Materia.getId_Materia()}">${Materia.getNombre()}</form:option>
						</c:forEach>       
						</form:select>
						</c:forEach>
			
				   </div>
				   <br>
				   <br>
                    <div class="form-group">
                     <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                       <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel" style=" padding-top: 7px;text-align: right;">
                          <span style="color: red"></span> </div>
                        
						<div class=" btn-group  buttons col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad">
						
		 
						
						<label class="btn btn-primary">
						  <form:radiobutton path="Tipo" value="Alumno" name="options1" id="option1" /> ALUMNO
						</label>
						<label class="btn btn-primary">
						  <form:radiobutton path="Tipo"  value="Profesor" name="options2" id="option2" />PROFESOR
						</label>                
                                         
                        </div>
                       <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                    </div>
                        <div class="form-group">
									<div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
									<div class="col-sm-11 col-md-11 col-lg-11 col-xs-10" style="text-align:center;">
										<button id="valuser" type="submit" onsubmit="return submitForm()"
											class="btn btn-success">
											CREAR USUARIO</button>
									</div>

									<div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
								</div>  	
         <div class="form-group">
                     <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12" id="message1" style="font-weight: bold; text-align: center;font-size: 10pt;">
						</div>
						 </div>	            
     
			</fieldset>
		
				</form:form>
                </div>
		    </div>
		    
	</div>
</div>

<script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath}/static/js/crearusuario.js"></script>
   
     <script type="text/javascript">
	$(function() {
	    
			$('#Carreras').change(function(e) {
				$(".mostrar").addClass("ocultar");
				$("#"+this.value+"Carrera").removeClass("ocultar");
				$("#"+this.value+"Carrera").addClass("mostrar");
				e.preventDefault();
		});
		$('#ckb').change(function(e) {
			
			if ($("#ckb").prop("checked")) 
			{
				$("#name").removeClass("ocultar");
				$("#Carreras").removeClass("ocultar");	
				$("#lbl").text("Describa brevemente el contenido del apunte");
				$("#text").removeClass("ocultar");
			}
			else
				{
				$("#name").addClass("ocultar");
				$("#Carreras").addClass("ocultar");		
				$("#lbl").text("");
				$("#text").addClass("ocultar");
				$("#name").addClass("ocultar");
				$("select").addClass("ocultar");
				$("#Carreras").val('1');
				}
			e.preventDefault();
		});
	
	});
	
	</script>
</body>
</html>