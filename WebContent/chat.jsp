<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<%@ page import="Model.*" %> 
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from demo.foxthemes.net/instellohtml/chat.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:08 GMT -->
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
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

    <style>
        @media (min-width: 1024px) {
            .container {
                max-width: 950px !important;
                padding-top: 30px !important;
            }
        }
    </style>
</head>

<body>


    <div id="wrapper">

        <div class="sidebar" style="background-color:#f0f2f5;;">
            <div class="sidebar_header border-b border-gray-200 from-gray-100 to-gray-50 bg-gradient-to-t  uk-visible@s"> 
                <a href="#">
                    <img src="assets/images/logo.png">
                    <img src="assets/images/logo-light.png" class="logo_inverse">
                </a>
                <!-- btn night mode -->
                <a href="#" id="night-mode" class="btn-night-mode" data-tippy-placement="left" title="Switch to dark mode"></a>
            </div>
        </div>

        <div class="main_content">

            <header>
                <div class="header_inner">
                    <div class="left-side">
                        <!-- Logo -->
                        <div id="logo" class=" uk-hidden@s">
                            <a href="home.html">
                                <img src="assets/images/logo-mobile.png" alt="">
                                <img src="assets/images/logo-mobile-light.png" class="logo_inverse">
                            </a>
                        </div>

                        <div class="triger" uk-toggle="target: #wrapper ; cls: sidebar-active">
                            <i class="uil-bars"></i>
                        </div>

                        <div class="header_search">
                            <input type="text" placeholder="Search..">
                            <div class="icon-search">
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                    stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                        d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                                </svg>
                            </div>
                        </div>

                    </div>
                    <div class="right-side lg:pr-4">
 						 <a href="#">
                            <img src="assets/images/avatars/defaultpicture.png" class="header-avatar" alt="profilepicture">
                        </a>
                        <div uk-drop="mode: click;offset:9" class="header_dropdown profile_dropdown border-t">
                            <ul>
                                <li><a href="ChangePassword.jsp">Change Password </a> </li>
                                <li><a href="LogoutServlet">Log Out</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </header>

		
            <div class="container m-auto pt-5">
                
                <h1 class="font-semibold lg:mb-6 mb-3 text-2xl"> Messages</h1>

                <div class="lg:flex lg:shadow lg:bg-white lg:space-y-0 space-y-8 rounded-md lg:-mx-0 -mx-5 overflow-hidden lg:dark:bg-gray-800" style="height: 300px;">
                    <div class="lg:w-4/12 bg-white border-r overflow-hidden dark:bg-gray-800 dark:border-gray-600">
						<p style="text-align: center;
							    margin: 50px 10px 20px 20px;
							    padding: 10px 10px 10px 10px;
							    font-size: 18px;
							    text-decoration: double;
							    color: #f87171;
							    text-transform: capitalize;"><%= request.getParameter("name") %></p>
                    </div>

                    <!--  message-->
                    <div class="lg:w-8/12 bg-white dark:bg-gray-800">

                        <div class="px-5 py-4 flex uk-flex-between">                                          
                         <h3 class="lg:w-60 mx-auto text-sm uk-heading-line uk-text-center lg:pt-2"><span><%= (new java.util.Date()).toLocaleString()%></span></h3>
                      
                            <button class="flex hover:text-red-400 items-center leading-8 space-x-2 text-red-500 font-medium"> 
                               <!--  <i class="uil-trash-alt"></i> <span class="lg:block hidden"> Delete Conversation </span> 
                            --> </button>
                        </div>
                         
                         
                        <div class="border-t dark:border-gray-600">
	                        <form action="SendMessageServlet" method="post">
	                            <div class="border-t flex p-6 dark:border-gray-700">
	                                <textarea cols="1" rows="1" placeholder="Your Message.."  name="msgcontent" class="border-0 flex-1 h-10 min-h-0 resize-none min-w-0 shadow-none dark:bg-transparent" style="height: 202px;"></textarea>
	                                <input type="hidden" value="<%= request.getParameter("userId") %>" name="frndid">
	                                  <input type="hidden" value="<%= request.getParameter("name") %>" name="frndname">
	                                <div class="flex h-full space-x-2">
	                                    <button type="submit" class="bg-blue-600 font-semibold px-6 py-2 rounded-md text-white" style="    margin-top: 160px;background-color: #f87171; color:white">Send</button>
	                                </div>
	                            </div>
							</form>
                        </div>
                    
                    </div>
                </div>
            
            </div>

        </div>

    </div>


    <script>
        
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
    </script>
 <!-- Scripts
    ================================================== -->
    <script src="assets/js/tippy.all.min.js"></script>  
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/uikit.js"></script>
    <script src="assets/js/simplebar.js"></script>
    <script src="assets/js/custom.js"></script>

</body>

</html>