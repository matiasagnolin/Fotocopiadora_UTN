<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fonts/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/user.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Article-List.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Footer-Clean.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/Login-Form-Clean.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/controller.js"></script>
</head>
<body >
<nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">fotocopiadora</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <button class="btn btn-primary navbar-btn navbar-right" type="button"><strong>SUBIR ARCHIVO</strong></button>
            </div>
        </div>
    </nav>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/Home"><span>INICIO </span></a></li>
        <li class="active"><span>DETALLE </span></li>
    </ol>
    <div class="container">
        <div class="row product">
            <div class="col-md-7">
            <c:if test = "${archivo.isAprobado()}">
                <form:form action="${pageContext.request.contextPath}/Actualizar" modelAttribute="producto" method="post">
                <form:input class="form-control" type="text" path="name" style="width: 50%;margin: 20px;"  value="${archivo.getNombre()}"/>
                <div class="col-md-3">
                     <img class="img-responsive" 
                     <c:if test = "${archivo.getTipo()=='PDF'}">src="${pageContext.request.contextPath}/static/images/pdf.png"</c:if> 
                     <c:if test = "${archivo.getTipo()!='PDF'}">src="${pageContext.request.contextPath}/static/images/doc.png"</c:if>
                     alt="imagen del producto">
                 </div>
                 <div class="col-md-7">
                    <form:textarea name="comentarios" placeholder="${archivo.getResumen()}" rows="6" path="comment" maxlength="140"  cols="40" ></form:textarea>
                </div>
                <form:hidden path="IdArchivo" value="${archivo.getId_Archivo()}"/>
                <button class="btn btn-primary navbar-btn navbar-right" type="submit"><strong>GUARDAR</strong></button>
                </form:form>
                <form:form action="${pageContext.request.contextPath}/Eliminar" modelAttribute="producto" method="post">
                <form:hidden path="IdArchivo" value="${archivo.getId_Archivo()}"/>
                <button class="btn btn-primary navbar-btn navbar-right" type="submit"><strong>ELIMINAR PRODUCTO</strong></button>
                </form:form>
                </c:if>
                <c:if test = "${!archivo.isAprobado()}">
                <form:form action="${pageContext.request.contextPath}/Aprobar" modelAttribute="producto" method="post">
                <h2><c:out value="${archivo.getNombre()}"/> </h2>
                <div class="col-md-3">
                     <img class="img-responsive" 
                     <c:if test = "${archivo.getTipo()=='PDF'}">src="${pageContext.request.contextPath}/static/images/pdf.png"</c:if> 
                     <c:if test = "${archivo.getTipo()=='DOC'}">src="${pageContext.request.contextPath}/static/images/doc.png"</c:if>
                     alt="Chania">
                 </div>
                 <div class="col-md-7">
                    <p>${archivo.getResumen()}</p>
                    <h4>Materia: <c:out value="${archivo.getMateria().getNombre()}"/> </h4>
                    <h4>Carrera: <c:out value="${archivo.getCarrera().getDescripcion()}"/></h4>
                    <form:hidden path="IdArchivo" value="${archivo.getId_Archivo()}"/>
                    <form:hidden path="Aprobado" value="true"/>
                    <button class="btn btn-primary navbar-btn navbar-right" type="submit"><strong>APROBAR</strong></button>
                    
                </div>
                </form:form>
                <form:form action="${pageContext.request.contextPath}/Aprobar" modelAttribute="producto" method="post">
                <form:hidden path="IdArchivo" value="${archivo.getId_Archivo()}"/>
                <form:hidden path="Aprobado" value="false"/>
                    <button class="btn btn-primary navbar-btn navbar-right" type="submit"><strong>NO APROBAR</strong></button>
                </form:form>
                </c:if>
              </div>
             </div>
            </div>
                <footer class="site-footer">
        <div class="container">
            <hr>
            <div class="row">
                <div class="col-sm-6">
                    <h5>UTN FRGP © 2017</h5></div>
                <div class="col-sm-6 social-icons"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div>
            </div>
        </div>
    </footer>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    
</body>
</html>