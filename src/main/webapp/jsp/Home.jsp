<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
     
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">  
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/user.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Article-List.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Footer-Clean.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/Login-Form-Clean.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/datatables.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/ekko-lightbox.css">
    <style>
	.clase_principal {opacity:0.3;}
	.mostrar{display:inline;}
	.ocultar{display:none}
	.centrar
	{
		position: fixed;
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
		display:block;
		opacity:1;
	}
</style>

</head>
<body>
<div id="capa_principal">
 <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <div class="navbar-left rounded-circle">
                    <a href="#" class="logo nvar-brand "><img src="${pageContext.request.contextPath}/static/images/printer_2.png"></a> 
                    <a class="navbar-brand" href="#">impresora web</a>
                    <a class="navbar-link facultad"  href="#"> utn regional pacheco.</a>
                 </div>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <button class="btn btn-primary navbar-btn navbar-right" type="button" id="SubirArchivo"><strong>SUBIR ARCHIVO</strong></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
            <form action="${pageContext.request.contextPath}/DestruirSesion" method="post">
                <button type="submit" name="button" value="your_value" class="btn-link navbar-right">SALIR</button>
                </form>
                            </div>
                            <c:if test = "${usuario.getRole_Usuario().getDescripcion()=='class ar.com.model.domain.Alumno'}">
                <div class="collapse navbar-collapse" id="navcol-1">
                <form action="${pageContext.request.contextPath}/CarritoController" method="post">
                <button type="submit" name="button" value="your_value" class="btn-link navbar-right">VER CARRITO</button>
                </form>
                </div>
                </c:if>
           <!-- <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar">
                    </span>
                </button>-->
<!--        <div class="menu">
            <ul class="nav navbar-nav  collapse navbar-collapse" id="navcol-1">
                <li role="presentation"><a href="#">Apuntes </a></li>
                <li role="presentation"><a href="#">Mas Vendidos</a></li>
                <li role="presentation"><a href="#">Novedades </a></li>
                <li role="presentation"><a href="#">¿Como Funciona?</a></li>
            </ul>
        </div>-->
           <!-- <div class="navbar-right ingesar">
                <button class="btn btn-primary navbar-btn" id="popup"type="button">SUBIR ARCHIVO></button>
                <div class="card" data-toggle="lightbox" id="card" >
                <h3 class="card-header">Elegir Archivo</h3>
                <div class="card-block">
                <h4 class="card-title">Elige tu propio archivo</h4>
                <p class="card-text">Elegí tu archivo desde tu computadora para que sea impreso.</p>
                <a href="#" class="btn btn-primary">Continuar</a>
          </div>
         </div>
        </div>  -->
                
                
        </div>  
    </nav>
    <ol class="breadcrumb">
        <!--<li><a href="#"><span>Store </span></a></li>
        <li><a href="#"><span>Men</span></a></li>-->
        <li class="active"><span>INICIO</span></li>
    </ol>
        <div>
          <div class="container">
          <!--<ul class="list-group">
                <li class="list-group-item">
                    <span>NOMBRE APUNTE EXTENSION </span>
                </li>
                <li class="list-group-item">
                </li>
                <li class="list-group-item">
                </li>
                <li class="list-group-item">
                </li>
            </ul>-->
            
            <div class="table-responsive">
                <table id="example" class="table table-bordered table-hover table-striped" >
                    <thead>
                        <tr>
                            <th>File Name</th>
                            <th>Subject</th>
                           <th>Carrera</th>
                            <th>User</th>
                            <th>date</th>
                            <th>action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${archivos}" var="item">
      				  <c:if test = "${!item.isDeleted()}">
                        <tr  id="${item.getId_Archivo()}">
                            <td>${item.getNombre()}.${fn:toLowerCase(item.getTipo())}</td>
                            <td>${item.getMateria().getNombre()}</td>
                            <td>${item.getCarrera().getDescripcion()}</td>
                            <td>${item.getUser().getNombre_Usuario()}</td>
                            <td>${item.getFecha()}</td>
                            <td>
                            <c:if test = "${usuario.getRole_Usuario().getDescripcion()=='class ar.com.model.domain.Alumno'}">
                            <form:form action="${pageContext.request.contextPath}/DetalleProducto" method="post">
                            
                              <input type="hidden"  id="archivo" name="archivo" value="${item.getId_Archivo()}" />
                              
  								<button type="submit" name="button" value="your_value" class="btn-link">IMPRIMIR</button>
  								</form:form>
  								</c:if>
  							<c:if test = "${usuario.getRole_Usuario().getDescripcion()=='class ar.com.model.domain.Profesor'}">
                            <form:form action="${pageContext.request.contextPath}/Producto" method="post">
                            
                              <input type="hidden"  id="archivo" name="archivo" value="${item.getId_Archivo()}" />
                              <c:if test = "${item.isAprobado()}">
  								<button type="submit" name="button" value="your_value" class="btn-link">ACTUALIZAR</button>
  								</c:if>
  								<c:if test = "${!item.isAprobado()}">
  								<button type="submit" name="button" value="your_value" class="btn-link">APROBAR</button>
  								</c:if>
  								</form:form>
  								</c:if>
                            </td>
                        </tr>
                       </c:if>
      				</c:forEach>   
                    </tbody> 
                    <tfoot></tfoot>
                </table>
			
            </div>
             <% if (session.getAttribute("ERROR")!=null) { %>
        	<% if (session.getAttribute("ERROR").equals(true)) { %>
			<div class="alert alert-danger"><p>ERROR! el archivo no pudo ser cargado.</p></div>
		<% }else{%>
		<div class="alert alert-success">ARCHIVO SUBIDO SATISFACTORIAMENTE</div>
		<% }}%>
        </div>
        </div>
        
       
    <div class="footer-clean">
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-4 item">
                        <h3>¿Donde estamos?</h3>
                        <ul>
                            <li><a href="#">Av. Hipólito Yrigoyen 288 - Gral. Pacheco (Tigre)</a></li>
                            <li><a href="#">Teléfonos: (5411)-4740-5040 / (5411)-4740-0216 /(5411)-4740-0119 / (5411)-4736-9198</a></li>
                            <li><a href="#">Fax: (5411)-4740-0167</a></li>
                            <li><a href="#">Código Postal: 1617</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 col-sm-4 item">
                        <h3>About</h3>
                        <ul>
                            <li><a href="#">Company</a></li>
                            <li><a href="#">Team</a></li>
                            <li><a href="#">Legacy</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 col-sm-4 item">
                        <h3>Careers</h3>
                        <ul>
                            <li><a href="#">Job openings</a></li>
                            <li><a href="#">Employee success</a></li>
                            <li><a href="#">Benefits</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 item social">
                        <p class="copyright">UTN FRGP© 2017</p>
                    </div>
                </div>
            </div>
        </footer>
    </div>
 </div>
 <div id="capa_datos" style="display:none">
		<div class="panel panel-default">
		<div class="panel-heading clearfix">
      <h4 class="panel-title pull-left" style="padding-top: 7.5px;">ELIGE TU ARCHIVO PARA IMPRIMIR</h4>
      <div class="btn-group pull-right">
        <a id="Cancelar"href="#" class="btn btn-default btn-sm">X</a>
      </div>	
      </div> 	
	 <div class="panel-body">
     <form:form  id="FileUploadForm" action="${pageContext.request.contextPath}/LoadFile" method="post"  modelAttribute="command" enctype="multipart/form-data">
		<div class="form-group">
			<form:input path="file" type="file"  id="file" name="file" />
		</div>
		<div class="form-group">
		<c:if test = "${usuario.getRole_Usuario().getDescripcion()=='class ar.com.model.domain.Profesor'}">
		<input type="hidden" value="true" id="profesor"/>
		</c:if>
		<c:if test = "${usuario.getRole_Usuario().getDescripcion()=='class ar.com.model.domain.Alumno'}">
		<input type="hidden" value="false" id="profesor"/>
		</c:if>
		<form:checkbox id="ckb" path="publico"  />
		<label>Publico</label>
		</div>
		
		<div class="form-group ">
			<form:input path="fileName" type="text" placeholder="File Name"  id="name" name="name" />
		</div>
		<div class="form-group">
			<form:select class="ocultar" id="Carreras" path="carrera" name="Carreras"> <!-- SELECT DE CARRERAS, LO TENES QUE USAR. LE MANDO LAS CARRERAS DESDE EL CONTROLLER -->
					<form:option value="0" label="--- Elegir Carrera ---" />
			<c:forEach items="${carreras}" var="Carrera">
			        <form:option value="${Carrera.getId_Carrera()}">${Carrera.getDescripcion()}</form:option>
			</c:forEach>
			</form:select>
			
			<c:forEach items="${carreras}" var="Carrera">
			<form:select  class="ocultar" id="${Carrera.getId_Carrera()}Carrera"  path="materia" name="Materias"> <!--ES TE ES EL DE MATERIAS LE TENES QUE AGREGAR LA PROPIEDAD MULTIPLE PARA PODER ELEGIR VARIAS CON LA TECLA CONTROL APRETADA -->
					<form:option value="0" label="--- Elegir Materia ---" />
			<c:forEach items="${Carrera.getMaterias()}" var="Materia">  <!--TOMA LAS MATERIAS DEL OBJECTO MATERIAS -->
			        <form:option value="${Materia.getId_Materia()}">${Materia.getNombre()}</form:option>
			</c:forEach>       
			</form:select>
			</c:forEach>
			
		</div>

		<div class="form-group">
		<label id="lbl"></label>
		</div>
		<div  class="form-group">
		<form:textarea class="ocultar" id="text" name="Resumen" rows="6" path="resumen" maxlength="140" cols="40" ></form:textarea>
		</div>
		
		
		
		
		<div class="form-group">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<input type="submit" name="register-submit" id="register-submit" class="btn btn-primary " value="IMPRIMIR ARCHIVO">
				</div>
			</div>
		</div>
		
	</form:form>
  </div>
</div>
								
      </div>  
        
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/DataTable/datatables.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/js/bs-animation.js"></script>
   <script src="${pageContext.request.contextPath}/static/js/ekko-lightbox.min.js"></script>
    <script>
    $(document).ready(function() {
       $('#example').DataTable();} );
    </script>
    <script type="text/javascript">
    function profesor(){
	$("#name").removeClass("ocultar");
	$("#Carreras").removeClass("ocultar");	
	$("#lbl").text("Describa brevemente el contenido del apunte");
	$("#text").removeClass("ocultar");
	$("#ckb").addClass("ocultar");}
    </script>
	<script type="text/javascript">
	$(function() {
	    $('#SubirArchivo').click(function(e) {
	    	$("#capa_datos").addClass("centrar");
			$("#capa_datos").delay(100).fadeIn(1000);
			$("#capa_principal").addClass("clase_principal");
			$("#name").addClass("ocultar");
			if($("#profesor").val()=="true")
				profesor();
			e.preventDefault();
		});
			$('#Cancelar').click(function(e) {
				$("#capa_datos").delay(100).fadeOut(1000);
			$("#capa_principal").removeClass("clase_principal");
			e.preventDefault();
		});
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