<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery.datetimepicker.min.css">
    
    
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/controller.js"></script>
    <style type="text/css">
    input:invalid + span {
  position: relative;
}

input:invalid + span:after {
  content: '✖';
  position: absolute;
  right: -18px;
}

input:valid + span {
  position: relative;
}

input:valid + span:after {
  content: '✓';
  position: absolute;
  right: -18px;
}
</style>

</head>
<body >
<nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand navbar-link" href="#">fotocopiadora</a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
               <form:form action="${pageContext.request.contextPath}/Home" method="post"  >
                <button class="btn btn-primary navbar-btn navbar-right" type="Submit"><strong>SEGUIR COMPRANDO</strong></button>
                </form:form>
            </div>
        </div>
    </nav>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/Home"><span>INICIO </span></a></li>
        <li><a href="${pageContext.request.contextPath}/Home"><span>DETALLE </span></a></li>
        <li class="active"><span>CARRITO </span></li>
    </ol>
    <form:form action="${pageContext.request.contextPath}/FinalizarPedido" method="post" modelAttribute="UpdateCant" >
    <div class="container">
    <div class="col-md-3" style="float:right">
              	<h4>SUBTOTAL</h4>
             </div>
     <c:forEach items="${pedido.getDetalleventa()}" var="detalle" varStatus="theCount">
        <div class="row product" style="padding:10px;margin-bottom:20px">
            <div class="col-md-8">
                <div class="col-md-2">
                     <img class="img-responsive" 
                     <c:if test = "${detalle.getArchivo().getTipo()=='PDF'}">src="${pageContext.request.contextPath}/static/images/pdf.png"</c:if> 
                     <c:if test = "${detalle.getArchivo().getTipo()!='PDF'}">src="${pageContext.request.contextPath}/static/images/doc.png"</c:if>
                     alt="Chania">
                 </div>
                 <div class="col-md-7">
                 <div class="col-md-9">
                 <h2><c:out value="${detalle.getArchivo().getNombre()}"/></h2>
                 </div>
                 <form:form action="${pageContext.request.contextPath}/DeleteDetalle" method="post" >
                	<input type="hidden"  id="IdArchivo" name="IdArchivo" value="${detalle.getArchivo().getId_Archivo()}" />
                	<button class="btn btn-primary navbar-btn navbar-right" type="Submit"><strong>X</strong></button>
                 </form:form>
                 
                 <div class="col-md-12">
                    <p>Sed mollis, urna eu tempus facilisis, diam tellus aliquam tortor, et vestibulum ante quam non justo. Nullam luctus rutrum mattis. Maecenas in pharetra mi, vel mollis odio. Morbi non mauris massa. </p>
                  </div>  
                </div>
             </div>
             
             <div class="col-md-3" style="float:right">
              	<h1 style="display: list-item;" id="subtotal${theCount.count}">$<c:out value="${detalle.getTotalParcial()}"/></h1>
              	<input id="valor${theCount.count}" type="hidden" value="${detalle.getTotalParcial()}"/>
             </div>
             <div class="col-md-3" style="float:right; padding:0;">
				<span class="help-block">ELIJA SU CANTIDAD.</span>
                 	<div class="col-xs-1"  style="padding:0;" >
                		<button id="suma${theCount.count}" onclick="suma(${theCount.count})"type="button" class="btn btn-primary btn-sm">+</button>
                	</div>
                	 <div class="col-xs-3" style="padding-bottom: 10px;">
                	 <form:input path="Cantidad" type="number" id="cantidad${theCount.count}" class="form-control" min="1" max="50" value="1" style="padding:0px" readonly="readonly"/>
                	 </div>
                    <div class="col-xs-2" style="padding:0;">
                    	<button id="resta${theCount.count}"  onclick="resta(${theCount.count})" type="button" class="btn btn-primary btn-sm"> -</button>
                    </div>
               </div> 
         </div>   
         
             
        </c:forEach>
       
      
	    <div class="row">
         <div class="col-md-7">	            
           <div class="col-md-5">
			 <div class="col-md-7" style="padding: 0px">
			 <span class="help-block">ELIJA LA FECHA DE RETIRO.</span>                
              <form:input id="deliveryDate" path="deliveryDate" onclick="setMinimum()" data-date-format="yyyy-mm-dd"  type="date" required="required" />
            </div>
            <span class="validity"></span>
	     </div>
	       <div class="col-md-5">
	         <button class="btn btn-primary navbar-btn navbar-right"  type="submit"><strong>FINALIZAR COMPRA</strong></button>
	      </div> 
	   </div>     
	 </div>
	</div>
	 </form:form> 
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
    <script src="${pageContext.request.contextPath}/static/js/jquery.datetimepicker.full.min.js"></script>
    <script type="text/javascript">
    $.datetimepicker.setLocale('en');
    $('#datetimepicker').datetimepicker();
    $(function () {
        $('#datetimepicker').datetimepicker({
            daysOfWeekDisabled: [0, 6]
        });
    });
    </script>
    	<script type="text/javascript">
	function suma(id){
		if(parseInt($("#cantidad"+id).val())+1<51){
		 cant = parseInt($("#cantidad"+id).val());
		 cant=cant+1;
		 subtotal=$("#valor"+id).val();
		 rest=parseInt(subtotal)*cant;
		 $("#subtotal"+id).text("$"+rest+".0");
		 $("#cantidad"+id).val(cant);}
	}
	function resta(id){
		if(parseInt($("#cantidad"+id).val())-1>0){	
			cant = parseInt($("#cantidad"+id).val());
			 cant=cant-1;
			 subtotal=$("#valor"+id).val();
			 rest=parseInt(subtotal)*cant;
			 $("#subtotal"+id).text("$"+rest+".0");
			 $("#cantidad"+id).val(cant);
			 }
	}
	function setMinimum(){
		$( '#deliveryDate' ).datepicker( 'option', 'minDate', new Date());
		
	}
	
	</script>    
	 <script>
      
	 $('#deliveryDate').change(function(e) {
		 var selectedText = $('#deliveryDate').val();
		   var selectedDate = new Date(selectedText);
		   var now = new Date();
		   if (selectedDate <= now) 
		    {
		    	alert("Date must be in the future");
		    	$('#deliveryDate').val(now+1);
		    }
	 });
    </script>
</body>
</html>