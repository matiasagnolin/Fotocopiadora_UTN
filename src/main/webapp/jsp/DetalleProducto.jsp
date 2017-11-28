<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
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
<body ng-controller="Controller">
<nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">fotocopiadora</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
           
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
                <h2><c:out value="${archivo.getNombre()}"/> </h2>
                <div class="col-md-3">
                     <img class="img-responsive" 
                     <c:if test = "${archivo.getTipo()=='PDF'}">src="${pageContext.request.contextPath}/static/images/pdf.png"</c:if> 
                     <c:if test = "${archivo.getTipo()!='PDF'}">src="${pageContext.request.contextPath}/static/images/doc.png"</c:if>
                     alt="Chania">
                 </div>
                 <div class="col-md-7">
                    <p>Sed mollis, urna eu tempus facilisis, diam tellus aliquam tortor, et vestibulum ante quam non justo. Nullam luctus rutrum mattis. Maecenas in pharetra mi, vel mollis odio. Morbi non mauris massa. </p>
                </div>
              </div>
            <div class="col-md-3" style="float:right">
                    <h1>$<span id="result"></span></h1>
                    <c:forEach items="${valores}" var="valor">
				  		<c:if test = "${valor.getDescripcion()=='Anillado'}">
                        <input type="hidden"  id="Anillado" name="Anillado" value="${valor.getValor()}" />
                        <input type="hidden"  id="IdAnillado" name="IdAnillado" value="${valor.getId_Valor()}" />
                        </c:if>
                        <c:if test = "${valor.getDescripcion()=='DobleFaz'}">
                        <input type="hidden"  id="DobleFaz" name="DobleFaz" value="${valor.getValor()}" />
                        <input type="hidden"  id="IdDobleFaz" name="IdDobleFaz" value="${valor.getId_Valor()}" />
                        </c:if>
                        <c:if test = "${valor.getDescripcion()=='SimpleFaz'}">
                        <input type="hidden"  id="SimpleFaz" name="SimpleFaz" value="${valor.getValor()}" />
                        <input type="hidden"  id="IdSimpleFaz" name="IdSimpleFaz" value="${valor.getId_Valor()}" />
                        </c:if>
      				</c:forEach>
      				<input type="hidden"  id="CantPag" name="CantPag" value="${archivo.getCantPag()}" />
      				<form:form action="${pageContext.request.contextPath}/DetallePedido" method="post"  modelAttribute="DetallePedido">
      				<form:input type="hidden" path="IdAnillado" id="AnilladoResult" name="AnilladoResult" />
      				<form:input type="hidden" path="IdDobleFaz"  id="DobleFazResult" name="DobleFazResult" />
      				<form:input type="hidden" path="IdSimpleFaz" id="SimpleFazResult" name="SimpleFazResult" />
      				<form:input type="hidden" path="Id_Archivo" id="idArchivo" name="idArchivo" value="${archivo.getId_Archivo()}"/>
					 <button class="btn btn-primary" type="Submit">AGREGAR AL PEDIDO</button>
				  </form:form>
              </div>
        </div>
        <div class="page-header">
                <h3>Detalles de la compra</h3></div>
        <div class="row product">
            <div class="col-md-10" style="padding-left: 0px;margin-top:20px">
                <div class="col-md-3">
                    <fieldset class="form-group row">					     
					      <div class="col-sm-10">
					        <div class="form-check">
					          <label class="form-check-label">
					            <input class="form-check-input" type="radio" name="gridRadios1" id="A3" value="A3" checked>
					            A3
					          </label>
					        </div>
					        <div class="form-check">
					          <label class="form-check-label">
					            <input class="form-check-input" type="radio" name="gridRadios1" id="A4" value="A4">
					            A4
					          </label>
					        </div>
					      </div>
    				</fieldset>   
            </div>
            <div class="col-md-7">
                    <p>Sed mollis, urna eu tempus facilisis, diam tellus aliquam tortor, et vestibulum ante quam non justo. Nullam luctus rutrum mattis. Maecenas in pharetra mi, vel mollis odio. Morbi non mauris massa. </p>
            </div> 
            <div class="col-md-2">
                <img class="img-responsive" src="${pageContext.request.contextPath}/static/images/A4.png" alt="Chania">
            </div> 
        </div>
        <div class="col-md-10" style="padding-left: 10px;margin-top:20px">
                <div class="col-md-3">
              		<label class="custom-control custom-checkbox mb-2 mr-sm-2 mb-sm-0">
				    <input id="AnilladoCheck" name="AnilladoCheck" type="checkbox" class="custom-control-input">
				    <span class="custom-control-indicator"></span>
				    <span class="custom-control-description">Anillado</span>
				  </label>
                </div>
                <div class="col-md-7">
                        <p>Sed mollis, urna eu tempus facilisis, diam tellus aliquam tortor, et vestibulum ante quam non justo. Nullam luctus rutrum mattis. Maecenas in pharetra mi, vel mollis odio. Morbi non mauris massa. </p>
                </div>
            <div class="col-md-2">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/static/images/anillado.png" alt="Chania">
                </div> 
        </div>
        <div class="col-md-10" style="padding-left: 10px;margin-top:20px">
                <div class="col-md-3">
                            <fieldset class="form-group row">					     
					      <div class="col-sm-10">
					        <div class="form-check">
					          <label class="form-check-label">
					            <input class="form-check-input" type="radio" name="gridRadios" id="SimpleFazCheck" value="option1" checked>
					            Simple Faz
					          </label>
					        </div>
					        <div class="form-check">
					          <label class="form-check-label">
					            <input class="form-check-input" type="radio" name="gridRadios" id="DobleFazCheck" value="option2">
					            Doble Faz
					          </label>
					        </div>
					      </div>
    				</fieldset>
                </div>
                <div class="col-md-7">
                        <p>Sed mollis, urna eu tempus facilisis, diam tellus aliquam tortor, et vestibulum ante quam non justo. Nullam luctus rutrum mattis. Maecenas in pharetra mi, vel mollis odio. Morbi non mauris massa. </p>
                </div>
            <div class="col-md-2">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/static/images/doble_faz.png" alt="Chania">
                </div> 
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