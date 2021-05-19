<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from demo.foxthemes.net/instellohtml/form-register.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:45 GMT -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="./bootstrap/Jquery/jquery-3.6.0.min.js">  </script>   <!-- //here i include jquery -->
    <!-- Favicon -->
    <link href="assets/images/favicon.png" rel="icon" type="image/png">
    
    <!-- Basic Page Needs
    ================================================== -->
    <title>Instello Sharing Photos</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Instello - Sharing Photos platform HTML Template">

    <!-- icons
    ================================================== -->
    <link rel="stylesheet" href="assets/css/icons.css">

    <!-- CSS 
    ================================================== -->
    <link rel="stylesheet" href="assets/css/uikit.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/tailwind.css">

</head>

<body class="bg-gray-100">


    <div id="wrapper" class="flex flex-col justify-between h-screen">

        <!-- Content-->

        <div>
            <div class="lg:p-12 max-w-md max-w-xl lg:my-0 my-12 mx-auto p-6 space-y-">
                <h1 class="lg:text-3xl text-xl font-semibold mb-6"> Sign in</h1>
                <p class="mb-2 text-black text-lg"> Register to manage your account </p>
                <form   name="form" action="RegisterUserServlet" method="post" onsubmit="return validatefun()" >
                    <div class="flex lg:flex-row flex-col lg:space-x-2">
                        <input type="text" name="regfirstname" id="txtfnameid" placeholder="First Name"  class="bg-gray-200 mb-2 shadow-none  dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
                        <input type="text" name="reglastname" id="txtlnameid" placeholder="Last Name" class="bg-gray-200 mb-2 shadow-none  dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
                    </div>
                    <input type="text" name="regemail" id="txtregemailid" placeholder="Email" class="bg-gray-200 mb-2 shadow-none  dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
                    <input type="password"  name="regpassword" id="txtregpasswordid" maxlength="8" placeholder="Password" class="bg-gray-200 mb-2 shadow-none  dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
                   
                    <button type="submit" class="bg-gradient-to-br from-pink-500 py-3 rounded-md text-white text-xl to-red-400 w-full">Register</button>
                    <div class="text-center mt-5 space-x-2">
                        <p class="text-base"> Do you have an account? <a href="form-login.jsp"> Login </a></p>
                    </div>
                </form>
            </div>
        </div>
         <tag:if test="${ErrorMessage != null}">
		<h3 style="color:red;">${ErrorMessage}</h3>
	</tag:if> 


    </div>
	
    <script type="text/javascript">
        
        (function (window, document, undefined) {
            'use strict';
            if (!('localStorage' in window)) return;
            var nightMode = localStorage.getItem('gmtNightMode');
            if (nightMode) {
                document.documentElement.className += ' dark';
            }
        })(window, document);
    
    
        (function (window, document, undefined) {
    
            'use strict';
    
            // Feature test
            if (!('localStorage' in window)) return;
    
            // Get our newly insert toggle
            var nightMode = document.querySelector('#night-mode');
            if (!nightMode) return;
    
            // When clicked, toggle night mode on or off
            nightMode.addEventListener('click', function (event) {
                event.preventDefault();
                document.documentElement.classList.toggle('dark');
                if (document.documentElement.classList.contains('dark')) {
                    localStorage.setItem('gmtNightMode', true);
                    return;
                }
                localStorage.removeItem('gmtNightMode');
            }, false);
    
        })(window, document);
        
      /*   function validatefun()
        { 
        	 var alertValidation="";
        	 var newLine = "\r\n";
             var regfname =document.getElementById("txtfnameid").value;
             var reglname = document.getElementById("txtlnameid").value;
             var regemailval = document.getElementById("txtregemailid").value;
             var regpasswordval =document.getElementById("txtregpasswordid").value; 
         
            // alert("hello");
             if (regfname==null || regfname=="")
             { 
            	 if(alertValidation=="")
         		 {
            		 alertValidation="Please enter First Name" + newLine; ; 
            	 }  
             }
         	 if(reglname==null || reglname=="")
             {           	
            	alertValidation= alertValidation + "Please enter Last Name." + newLine; ;  
             } 
        	 if(regemailval==null || regemailval=="")
             {           	
            	alertValidation= alertValidation + "Please Enter Email address." + newLine; ;  
             } 
        	 if(regpasswordval==null || regpasswordval=="")
             {           	
            	alertValidation= alertValidation + "Please enter Password." + newLine; ;  
             } 
             alert( alertValidation);
             return false;
        } */
/*         $(document).ready(function () {
        	/* $("#txtfnameid").blur(function(){
          	  alert("This input field has lost its focus.");
          	}); */
        	
        	
        	 /*  $("#txtregemailid").blur(function(){
        		  var singleValues = $( "#txtregemailid" ).val();
        		  checkemail(singleValues)
            	}); */
            	
            	
/*         	$("#txtregemailid").on("blur", function (event) {
        		   var email = $(this).val();
        		  // alert(email);
        		   var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        		   if (!filter.test(email)) {
        		      alert('Please enter a valid email address');
        		      return false;
        		   }
        		});
        	});  */
        
      
        
       /*  function checkemail(email)
        {
           var regex=/^[a-zA-Z0-9\.\_]+\@@{1}[a-zA-Z0-9]+\.\w{2,4}$/;
           if(!regex.test(email))
           {
               alert('Please enter valid email id');
            }
         } */
        
       

          
    </script>

    <!-- Scripts
    ================================================== -->
    <script src="assets/js/tippy.all.min.js"></script>
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/uikit.js"></script>
    <script src="assets/js/simplebar.js"></script>
    <script src="assets/js/custom.js"></script>


    <!-- <script src="../../unpkg.com/ionicons%405.2.3/dist/ionicons.js"></script> -->
</body>


<!-- Mirrored from demo.foxthemes.net/instellohtml/form-register.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:45 GMT -->
</html>