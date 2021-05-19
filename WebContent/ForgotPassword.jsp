<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <script type="text/javascript" src="./bootstrap/Jquery/jquery-3.6.0.min.js">  </script>   <!-- //here i include jquery -->
    <!-- Favicon -->
    <link href="assets/images/favicon.png" rel="icon" type="image/png">
    
    <!-- Basic Page Needs
    ================================================== -->
    <title>Social Spark</title>
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
   <%--  <jsp:directive.include file="header.jsp" /> --%>
     <!--  <div id="wrapper" class="flex flex-col justify-between h-screen">
      </div> -->
       <div>
           <div class="lg:p-12 max-w-md max-w-xl lg:my-0 my-12 mx-auto p-6 space-y-">
               <h1 class="lg:text-3xl text-xl font-semibold  mb-6">Reset Your Password</h1>
               <p class="mb-2 text-black text-lg"> Please enter your login email, we'll send a new random password to your inbox:</p>
                   <form id="resetForm" action="Reset_Password" method="post">
	          			<input type="text" name="forgotuseremail" id="txtemailId" placeholder="example@mydomain.com" class="bg-gray-200 mb-2 shadow-none dark:bg-gray-800" style="border: 1px solid #d3d5d8 !important;">
	                    <button type="submit" onsubmit="" class="bg-gradient-to-br from-pink-500 py-3 rounded-md text-white text-xl to-red-400 w-full">Send me new password</button>
	                   
        		   </form>
            </div>
       </div>
         
    
     
    <%-- <jsp:directive.include file="footer.jsp" /> --%>
     
<script type="text/javascript">
 
 /*    $(document).ready(function() {
        $("#resetForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                }      
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                }
            }
        });
 
    }); */
</script>
</body>
</html>