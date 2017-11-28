<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</head>

<body>
    <div class="login-clean">
        <form:form method="post" action="${pageContext.request.contextPath}/Login" name="form" id="form" modelAttribute="usuario">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration">
                <!--<i class="icon ion-ios-navigate"></i>-->
                <img src="${pageContext.request.contextPath}/static/images/utn.png" alt="">
            </div>
            <div class="form-group">
            <label class="sr-only" for="inlineFormInputGroup">Username</label>
					 <div class="input-group mb-2 mr-sm-2 mb-sm-0">
					   <div class="input-group-addon">FRGP</div>
					   <form:input type="text" path="Nombre_Usuario" class="form-control" id="inlineFormInputGroup" placeholder="Username"/>
					 </div>
            </div>
            <div class="form-group">
                <form:input class="form-control" type="password" path="Password_Usuario" name="password" placeholder="Password"/>
            </div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Log In</button>
            </div>
            <div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<c:if   test="${usuario.getError()}">
													   <p style="color:red">USUARIO O CONTRASEÑA INCORRECTA</p>
													</c:if>
												</div>
											</div>
										</div>
           
            
            </form:form>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
	
</html>