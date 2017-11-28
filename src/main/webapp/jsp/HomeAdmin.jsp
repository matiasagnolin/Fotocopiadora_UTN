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
             <form action="${pageContext.request.contextPath}/CrearUsuario" method="post">
                <button class="btn btn-primary navbar-btn navbar-right" type="submit" id="SubirArchivo"><strong>CREAR USUARIO</strong></button>
                 </form>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
            <form action="${pageContext.request.contextPath}/DestruirSesion" method="post">
                <button type="submit" name="button" value="your_value" class="btn-link navbar-right">SALIR</button>
                </form>
             </div>   
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
                            <th>Pedido</th>
                            <th>Fecha de Entrega</th>
                           <th>Fecha de creacion</th>
                            <th>Usuario</th>
                            <th>Pagado</th>
                            <th>Impreso</th>
                            <th>Total</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pedidos}" var="item">
      				  <c:if test = "${!item.isEntregado()}">
                        <tr  id="${item.getID_Venta()}">
                            <td>${item.getID_Venta()}</td>
                            <td>${item.getFecha_Entrega()}</td>
                            <td>${item.getFecha_Pedido()}</td>
                            <td>${item.getAlumno().getNombre_Usuario()}</td>
                            <c:if test = "${item.isPagado()}">
                            <td>SI</td>
                            </c:if>
                            <c:if test = "${!item.isPagado()}">
                            <td>NO</td>
                            </c:if>
                            <c:if test = "${item.isImpreso()}">
                            <td>SI</td>
                            </c:if>
                            <c:if test = "${!item.isImpreso()}">
                            <td>NO</td>
                            </c:if>
                            <td>${item.getTotal()}</td>
              				<td>
              				<c:if test = "${!item.isImpreso()}">
                            <form:form action="${pageContext.request.contextPath}/Imprimir" method="post">
                              <input type="hidden"  id="pedido" name="pedido" value="${item.getID_Venta()}" />       
  								<button type="submit" name="button" value="your_value" class="btn-link">IMPRIMIR</button>
  								</form:form>
  								</c:if>
  								<c:if test = "${item.isImpreso()}">
                            <form:form action="${pageContext.request.contextPath}/Imprimir" method="post">
                              <input type="hidden"  id="pedido" name="pedido" value="${item.getID_Venta()}" />       
  								<button type="submit" name="button" value="your_value" class="btn-link">ENTREGAR</button>
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
 
        
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/DataTable/datatables.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/js/bs-animation.js"></script>
   <script src="${pageContext.request.contextPath}/static/js/ekko-lightbox.min.js"></script>
    <script>
    $(document).ready(function() {
       $('#example').DataTable();} );
    </script>		
</body>
</html>