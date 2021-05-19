<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from demo.foxthemes.net/instellohtml/form-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:35 GMT -->
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="./bootstrap/Jquery/jquery-3.6.0.min.js">  </script>  
 
    <link href="assets/images/favicon.png" rel="icon" type="image/png">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
   	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    
   
    <title>Social Spark</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Instello - Sharing Photos platform HTML Template">

  
    <link rel="stylesheet" href="assets/css/icons.css">
    <link rel="stylesheet" href="assets/css/uikit.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/tailwind.css">

</head>

<body class="bg-gray-100">


    <div id="wrapper" class="flex flex-col justify-between h-screen">
        <div>
        <%      
	    Cookie[] cookies=request.getCookies();
	    String userName = "", password = "";
	    Boolean  rememberVal=false;
	    if (cookies != null) {
	         for (Cookie cookie : cookies) {
	           if(cookie.getName().equals("loginuseremail")) {
	             userName = cookie.getValue().trim();
	           }
	           if(cookie.getName().equals("loginpassword")){
	             password = cookie.getValue().trim();
	           }
	           if(cookie.getName().equals("rememberme")){
	             rememberVal = true;
	           }
	        }
	    }
	    /*  out.print("welcome "+userName+password);  */
	%>
            <div class="lg:p-12 max-w-md max-w-xl lg:my-0 my-12 mx-auto p-6 space-y-">
                <h1 class="lg:text-3xl text-xl font-semibold  mb-6"> Log in</h1>
                <p class="mb-2 text-black text-lg"> Email or Username</p>
                
                <form name="form" action="LoginServlet" method="post" >
                    <input type="text" name="loginusername" id="txtemailId" placeholder="example@mydomain.com / username" value="<%=userName%>" class="bg-gray-200 mb-2 shadow-none dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
                    <input type="password"  name="loginpassword" id="txtpasswordid" placeholder="***********" value="<%=password%>" class="bg-gray-200 mb-2 shadow-none dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
                    <div class="flex justify-between my-4">
                        <div class="checkbox">
                        <%if(rememberVal==true) { %>
                         <input type="checkbox" id="chekcbox1" name="rememberme" value="checked" checked/>
                         <% } else{%>
                            <input type="checkbox" id="chekcbox1" name="rememberme" value="checked" />
                         <%} %>
                            <label for="chekcbox1"><span class="checkbox-icon"></span>Remember Me</label>
                        </div>
                        <a href="ForgotPassword.jsp"> Forgot Your Password? </a>
                    </div>
                    <button type="submit" onsubmit="return validate()" class="bg-gradient-to-br from-pink-500 py-3 rounded-md text-white text-xl to-red-400 w-full">Login</button>
                    <div class="text-center mt-5 space-x-2">
                        <p class="text-base"> Not registered? <a href="form-register.jsp" class=""> Create a account </a></p>
                    </div>
                </form>

            </div>
        </div>
		
		 <tag:if test="${fetchpassword != null}">
			<h3 style="color:red;">${fetchpassword}</h3>
		</tag:if> 

		<% 
			String message = (String)request.getAttribute("alertMsg");
			//out.println(message);
			if(message!=null){%>
				<script type="text/javascript">
				    var msg = "<%=message%>";
				    alert(msg);
				</script> 
				
				<%} %>
				
    </div>


	
 <script type="text/javascript">
    $(document).ready(function () {

       
   });
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
        

        /*  function validate()
        { 
        	 var alertValidation="";
        	 var newLine = "\r\n"
             var emailval = document.getElementById("txtemailId").value;
             var passwordval =document.getElementById("txtpasswordid").value; 
         
             if (emailval==null || emailval=="")
             { 
            	 if(alertValidation=="")
         		 {
            		 alertValidation="Please enter Email or Username." + newLine; 
            	 }  
             }
         	 if(passwordval==null || passwordval=="")
             {           	
            	alertValidation= alertValidation + "Please enter Password.";  
             }  
         	 alert( alertValidation);
            
        }  */
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


</html>