function checkUserid(){
	var customerEnteredUid=document.getElementById("uid").value;
	if(customerEnteredUid=="john")
		alert("userid alreaady taken");
}



$(document).ready(function() {
	
	var person={
			name:"john",
			age:10
	}
	console.log("jobject:"+person);// print javascript object
	// javascript obect to json String
	var personJsonString=JSON.stringify(person);
	console.log("json converted:"+personJsonString); // print json
	console.log(person.age);// dot operator works on js object
	console.log(personJsonString.age);// dot operator does not work on json
	
	var dog='{ "name":"milo", "breed":"country" }';
	var jsObject=JSON.parse(dog);
	console.log(dog.name);
	console.log(jsObject.name);
	
	console.log("json:"+dog);
	console.log("js converted:"+jsObject);
	
	
	$("#dob").blur(validateDOB);
	$("#dob").mouseenter(TNFunHide);
	$("#dob").mouseleave(TNFunShow);
	
	// id the html element = $("#dob")
	// track event listener = .blur
	// when above element event listener is 
	// triggered call function = (validateDOB)
	
});
function TNFunHide(){
	$("#prodDisplay").css("background","red");
	$("#prodDisplay").css("border-style","dotted");
	$("#tn").bounceOutLeft();
	//$("#tn").hide(); // immideately disappear
	 //$("#imglogo").fadeOut(5000);// fade and disappear - 5 seconds - 5000 milli seconds
	$("#imglogo").slideDown(5000);// appear by sliding down
}
function TNFunShow(){
	$("#prodDisplay").css("background","yellow");
	
	$("#tn").show();// immideately appear
	//$("#imglogo").fadeIn(5000);// fade and appear - 5 seconds - 5000 milli seconds
	$("#imglogo").slideUp(5000); // disapper by sliding up
}

function validateDOB(){
	var a=$("#dob").val(   );
	 // access eleement = $("#dob")
	// access/read customer input = .val();
	if(a==""){
		$("#dob").val("please enter dob");
		 // access eleement = $("#dob")
		// write into input html element= .val(javascript setting value);
		
		$("#dob").css("background","red");
	}
	else
		$("#dob").css("background","white");
	
	console.log("customer entered date of birth:"+a);
	//$("#dob").css("background","blue");
	
	/*
	var dobstr=document.getElementById("dob").value;
	
	console.log(dobstr);
	// 12-20-2000
	var splitDOB=dobstr.split("-");
	var month=splitDOB[0];
	var date=splitDOB[1];
	var year=splitDOB[2];
	if(month > 12){
		document.getElementById("dob").style="background:red;transform:rotate(90deg);transition-duration: 20s";	
		
		
	}if(date > 31)
		alert("invalid date. should be less than 31");
	if(year > 2020)
		alert("invalid year. should be less than 2020");
	
	document.getElementById("dob").style="background:red";
	*/	
}
function variableSupport(){
	
	var userid=document.getElementById("uid").value;
	console.log("Customer typed userid as :"+userid);
	// should contain @
	// should contain .com
	// agmail.com
	if(userid == "")
		alert("userid is mandatory, please enter value before filling rest of the application form");
	
	if(userid.indexOf("@")   ==   -1)
		alert("invalid email id : email id should contain @");
	if(userid.indexOf(".com")   ==   -1)
		alert("invalid email id : email id should contain .com");
	
	
	// basic primitive data type with literal value
	var v="john";
	var b=true;
	var c='x';
	var d= 10;
	var e=10.0;
	
	//array data type
	var names=["john","jane"];
	console.log( names[0]  ) ;
	
	// object data type with variable, function
	var student={
		//String name="john";
		name : "john",
		age : 10,
		grade : 2,
		learn : function(  ){
			console.log("attending class");
		}
	};
	console.log(  student.age );
	student.learn();
	 
}

function verifyLoginForm(){
	var customerEnteredUid=document.getElementById("uid").value;
	var customerEnteredpwd=document.getElementById("pwd").value;
	if(customerEnteredUid == "" || customerEnteredpwd == "")
		alert(" userid and password is mandatory");
	if(customerEnteredUid.indexOf("@")  == -1 ){
		alert("invalid userid id");
		document.getElementById("uid").style="background:red";
	}
	
	/* jquery code
	var customerEnteredUid=$("#uid").val();
	var customerEnteredpwd=$(".pass").val();
	if(customerEnteredUid == "" || customerEnteredpwd == "")
		alert(" userid and password is mandatory");
	if(customerEnteredUid.indexOf("@")  == -1 ){
		alert("invalid userid id");
		$("#uid").css("background","red");
		$("#submit").hide();
	}
	$("#uid") - access html element by "id" attribute
	$(".pass") - access html element by "class" attribute
	$("label") - access html element by element name
	$("#products").fadeOut(3000);
	$("#uid").css("background","blue");
	$("#uid").val("set value");
	
	*/
	
}
function demoControlFLows( a, b){

	try{
		console.log("1");
		var a=10/2;
		console.log("2");
	}catch(e){
		console.log("3");
	}finally{
		console.log("4");
	}
	
	
	var email="abc@g.com";
	console.log(email);
	email=email.replace("a","c");
	console.log(email);
	var arr=email.split("@");
	console.log(arr);
	
	
	if(email.indexOf("@")  == -1 )
		alert("invalid email id");
	else
		alert("valid email id");


	for(i=0; i < 3;i++)
		console.log("hello :"+i);
	
	if ( a == b ){
		console.log("same");
	}
	else{
		console.log("not same");
	}
}