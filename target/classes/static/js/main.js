/**
 * 
 */
"use strict";
function fetchUsers(){
	
	
	
	
	/*var users = [{name:"akkhil",region:"india"},
	{name:"kumar",region:"india"},
	{name:"gupta",region:"india"}
	];
	
	
	
	var userList="";
	
	for(var i=0;i<users.length;i++){
		userList +=" "+ users[i].name;
	}
	
	alert("inside fetch users method"+ userList);*/
	
	
	$("#fetchUsers").click(function(){
	    $.ajax({type:"GET",url: "http://localhost:8080/students/Akhil/2/", success: function(result){
	    	//alert("success");
	        $("#div1").html(result);
	        console.log("esults is >>>> " + result)
	        
	        $.each( result, function( key, value ) {
	        	var element = document.createElement("div");
	        	element.appendChild(document.createTextNode(value.userid+" "));
	        	element.appendChild(document.createTextNode(value.preferredname+" "));
	        	element.appendChild(document.createTextNode(value.status));
	        	document.getElementById('div1').appendChild(element);
	        	//$("#"+value.userid+""+).html(value.preferredname);
	  		//  alert( key + ": " + value.userid+" " + value.status+" "+ value.preferredname );
	  		});
	    }});
	});
	
	
	
	
}