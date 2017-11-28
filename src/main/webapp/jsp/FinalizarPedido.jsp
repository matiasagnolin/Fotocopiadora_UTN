<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Credit Card Validation Demo</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/demo.css">
    <style type="
	.ocultar{display:none}"></style>
</head>

<body >
    <div class="container-fluid">
       
        <div class="creditCardForm">
            <div class="heading">
                <h1>METODOS DE PAGO</h1>
            </div>
            <div class="payment">
                
                    <div class="form-group owner">
                        <label for="owner">Owner</label>
                        <input  type="text" class="form-control" id="owner" >
                    </div>
                    <div class="form-group CVV">
                        <label for="cvv">CVV</label>
                        <input type="text" class="form-control" id="cvv"  >
                    </div>
                    <div class="form-group" id="card-number-field">
                        <label for="cardNumber">Card Number</label>
                        <input type="text" class="form-control" id="cardNumber"  >
                    </div>
                    <div class="form-group" id="expiration-date">
                        <label>Expiration Date</label>
                        <select>
                            <option value="01">January</option>
                            <option value="02">February </option>
                            <option value="03">March</option>
                            <option value="04">April</option>
                            <option value="05">May</option>
                            <option value="06">June</option>
                            <option value="07">July</option>
                            <option value="08">August</option>
                            <option value="09">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <select>
                            <option value="16"> 2016</option>
                            <option value="17"> 2017</option>
                            <option value="18"> 2018</option>
                            <option value="19"> 2019</option>
                            <option value="20"> 2020</option>
                            <option value="21"> 2021</option>
                        </select>
                    </div>
                    <div class="form-group" id="credit_cards">
                        <img src="${pageContext.request.contextPath}/static/images/visa.jpg" id="visa">
                        <img src="${pageContext.request.contextPath}/static/images/mastercard.jpg" id="mastercard">
                        <img src="${pageContext.request.contextPath}/static/images/amex.jpg" id="amex">
                    </div>
                    
           				        

		<form action="${pageContext.request.contextPath}/PagarCompra" method="post"  onSubmit="return validarpago()"> 
                    <div class="form-group" class="form-control" id="credit_cards" >
                        <button type="submit" class="btn btn-default" id="pay-now">PAGAR</button>
                    </div>
                    </form>
                    
                    <form action="${pageContext.request.contextPath}/NoPagar" method="post" onsubmit="return validar()">
                    <input type="hidden" class="form-control" id="credit_cards"> 
                    <div class="form-group" >
                        <button type="submit" id="retiro" class="btn btn-primary btn-sm" >PAGAR CUANDO RETIRO</button>
                   </div>
                </form>
			<form action="${pageContext.request.contextPath}/Home" method="post"> 
                    <div class="form-group" class="form-control"  id="credit_cards">
                        <button type="submit" class="btn btn-default" id="volver" >VOLVER</button>
                    </div>
                    </form>
                    <% if (session.getAttribute("terminado")!=null) { %>
        	<% if (session.getAttribute("terminado").equals(true)) { %>
			<input type="hidden" id="terminado" value="1">
		<% }}%>
		
		
            </div>
        </div>

      

        <div class="examples">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Type</th>
                            <th>Card Number</th>
                            <th>Security Code</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Visa</td>
                            <td>4716108999716531</td>
                            <td>257</td>
                        </tr>
                        <tr>
                            <td>Master Card</td>
                            <td>5281037048916168</td>
                            <td>043</td>
                        </tr>
                        <tr>
                            <td>American Express</td>
                            <td>342498818630298</td>
                            <td>3156</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.payform.min.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
    <script type="text/javascript">
    function validar(){
    	$('#pay-now').attr("disabled", true);
		$('#retiro').attr("disabled", true);
		return true;
    }
	function validarpago(){
		var result=true;
		if (document.getElementById('owner').value === '')
        {
            alert("El campo Owner esta vacio");
            document.getElementById("owner").focus();
            result= false;
            
        }
		
		else if (document.getElementById('cvv').value === '')
        {
            alert("El campo CVV esta vacio");
            document.getElementById("cvv").focus();
            result=false;
        }
		
		else if (document.getElementById('cardNumber').value === '')
        {
            alert("El campo Card Number esta vacio");
            document.getElementById("cardNumber").focus();
            result= false;
        }
		if(result){
			alert("a");
			document.getElementById("pay-now").disabled = true;
			document.getElementById("retiro").disabled = true;
			$('#pay-now').attr("disabled", true);
			$('#retiro').attr("disabled", true);
			
		}
		return result;
		
	}


</script>

	

</body>

</html>
