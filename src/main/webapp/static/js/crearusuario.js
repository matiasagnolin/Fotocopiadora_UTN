$(document).ready(function() {
 $("#view_button3").bind("mousedown touchstart", function() {
        $("#password").attr("type", "text");
    }), $("#view_button3").bind("mouseup touchend", function() {
        $("#password").attr("type", "password");
    }), $("#view_button4").bind("mousedown touchstart", function() {
        $("#verifypassword").attr("type", "text");
    }), $("#view_button4").bind("mouseup touchend", function() {
        $("#verifypassword").attr("type", "password")
    })
});
function passwordChecker(){
									 $('#verifypassword').val('');
									 $('#message1').html(''); $('#message8').html(''); $('#message10').html('');
									 $('#message').html('');$('#message2').html('');$('#message3').html('');$('#message4').html('');$('#message5').html('');$('#message6').html('');$('#message7').html('');
									 if($('#password').val().length>=4){
									 if(newValPassPoilcy()===true ){
										 $('#message').css('color','green');
										 $('#message').html('Although looks like a good password, try to make it more stronger');
									 if($('#password').val().length>=9){
										 $('#message').html('');
										 $('#message1').html('');
									 } 
										return true;
									}
									 }
									  
									 
								}

	
	function submitForm(){
		var result=true;
	     if(document.getElementById("username").value.trim()==="" && document.getElementById("username").value!==null){
	      $('#message1').css('color','red');
			 $('#message1').html('POR FAVOR INGRESE EL LEGAJO');   
			 result=false;
	     }
	     else if(document.getElementById("yourEmail").value.trim()==="" && document.getElementById("yourEmail").value!==null){
	      $('#message1').css('color','red');
			 $('#message1').html('INGRESE UN EMAIL');   
			 result=false;
	     }
	     else if(checkEmail()===false){
	          $('#message1').css('color','red');
			 $('#message1').html('EMAIL INCORRECTO'); 
			 result=false;

	     }
	      else if(document.getElementById("password").value.trim()==="" && document.getElementById("password").value!==null){
	      $('#message1').css('color','red');
			 $('#message1').html('INGRESE CONTRASEÑA');   
			 result=false;
	     }
	      else if(document.getElementById("verifypassword").value.trim()==="" && document.getElementById("verifypassword").value!==null){
	      $('#message1').css('color','red');
			 $('#message1').html('CONFIRME CONTRASEÑA');   
			 result=false;
	     }
	     
	  else{
	      var password=$('#password').val();
	      var confirm=$('#verifypassword').val();
	      if(password==confirm){
	          $('#message1').css('color','green');
	          $('#message1').html('');   
	            
	      }
	      else{
	          $('#message1').css('color','red');
			 $('#message1').html('CONFIRME CONTRSEÑA');   
			 result=false;
	     
	      }
		  result=false;
	  }
	  alert(result);
	   return result;
	}	
	function checkEmail(){
	   var email=$('#yourEmail').val();
	  if((email.indexOf(".") > 2) && (email.indexOf("@") > 0)){
	     return true; 
	  }
	  else{
	     return false;		 
	  }
	    
	}