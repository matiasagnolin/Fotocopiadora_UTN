angular.module("myapp",[])
.controller("Controller",function($scope){
	
	$('#SimpleFazCheck ,#DobleFazCheck , #AnilladoCheck , #A3, #A4').on('click' , function(){
	    var $a1Check  = $('#AnilladoCheck').is(':checked');
	    var $a2Check  = $('#DobleFazCheck').is(':checked');
	    var $a3Check  = $('#SimpleFazCheck').is(':checked');
	    var sum=0;
	    document.getElementById("SimpleFazResult").value=0;
	    document.getElementById("AnilladoResult").value=0;
	    document.getElementById("DobleFazResult").value=0;
	    if( $a1Check){
	    	sum=sum+parseInt($('#Anillado').val());
	    	document.getElementById("AnilladoResult").value=parseInt($('#IdAnillado').val());
	    }
	    if($a2Check){
	    	sum=sum+parseInt($('#CantPag').val())*parseInt($('#DobleFaz').val());
	    	document.getElementById("DobleFazResult").value=parseInt($('#IdDobleFaz').val());
	    }    
	    if($a3Check)  {
	    	sum=sum+parseInt($('#CantPag').val())*parseInt($('#SimpleFaz').val());
	    	document.getElementById("SimpleFazResult").value=parseInt($('#IdSimpleFaz').val());
	    }
	    document.getElementById("result").innerHTML =sum;
	});
	window.onload = function() {
		var $a1Check  = $('#AnilladoCheck').is(':checked');
	    var $a2Check  = $('#DobleFazCheck').is(':checked');
	    var $a3Check  = $('#SimpleFazCheck').is(':checked');
	    var sum=0;
	    document.getElementById("SimpleFazResult").value=0;
	    document.getElementById("AnilladoResult").value=0;
	    document.getElementById("DobleFazResult").value=0;
	    if( $a1Check){
	    	sum=sum+parseInt($('#Anillado').val());
	    	document.getElementById("AnilladoResult").value=parseInt($('#IdAnillado').val());
	    }
	    if($a2Check){
	    	sum=sum+parseInt($('#CantPag').val())*parseInt($('#DobleFaz').val());
	    	document.getElementById("DobleFazResult").value=parseInt($('#IdDobleFaz').val());
	    }    
	    if($a3Check)  {
	    	sum=sum+parseInt($('#CantPag').val())*parseInt($('#SimpleFaz').val());
	    	document.getElementById("SimpleFazResult").value=parseInt($('#IdSimpleFaz').val());
	    }
	    document.getElementById("result").innerHTML =sum;
		};
	
});
