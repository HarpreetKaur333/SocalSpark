<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<%@ page import="Model.*" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<script type="text/javascript" src="./bootstrap/Jquery/jquery-3.6.0.min.js">  </script>  
     <link rel="stylesheet" href="./assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
     <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/images/favicon.png" rel="icon" type="image/png">
	<link rel="stylesheet" href="./bootstrap/ExternalCSS/CSS.css"> <!-- external css -->
    
    <title>Socail Spark</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Instello - Sharing Photos platform HTML Template">

    <link rel="stylesheet" href="assets/css/icons.css">
    <link rel="stylesheet" href="assets/css/uikit.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/tailwind.css">
    
    <style>
        @media (min-width: 1024px) {
            header .header_inner {
                max-width: 980px;
            }

            .pro-container {
                max-width: 860px;
            }
        }
    </style>


</head>

<body>
   <%--  <% 
	User user =(User) session.getAttribute("loginuser"); 
	if(user == null){
		response.sendRedirect("LogoutServlet");
	}
%> --%>
    
        <div id="wrapper">
         <div class="sidebar" style="width:360px;">
            <div class="sidebar_header border-b border-gray-200 from-gray-100 to-gray-50 bg-gradient-to-t  uk-visible@s"> 
                <a href="#">
                    <img src="assets/images/favicon.png" style="display:inline">
                    <img src="assets/images/favicon.png" class="logo_inverse"><span style="color: #be185d;">Social Spark</span>
                </a>
               <!--  btn night mode -->
                <a href="#" id="night-mode" class="btn-night-mode" data-tippy-placement="left" title="Switch to dark mode"></a>
            </div>
            <div class="border-b border-gray-20 flex justify-between items-center p-3 pl-5 relative uk-hidden@s">
                <h3 class="text-xl"> Navigation </h3>
                <span class="btn-mobile" uk-toggle="target: #wrapper ; cls: sidebar-active"></span>
            </div>
            <div class="sidebar_inner" data-simplebar>
                <div class="flex flex-col items-center my-6 uk-visible@s" style="margin-top:0px; margin-bottom:0px;">
                    <div
                        class="bg-gradient-to-tr from-yellow-600 to-pink-600 p-1 rounded-full transition m-0.5 mr-2  w-24 h-24">
                        <img src="assets/images/avatars/defaultpicture.png"
                            class="bg-gray-200 border-4 border-white rounded-full w-full h-full">
                    </div>
                    <a href="profile.html" class="text-xl font-medium capitalize mt-4 uk-link-reset"> <%= session.getAttribute("loginuser") %>
                    </a>
                    <div class="flex justify-around w-full items-center text-center uk-link-reset text-gray-800 mt-6">
                      <!--   <div>
                            <a href="#">
                                <strong>Post</strong>
                                <div> countofpost</div>
                            </a>
                        </div> -->
                     <!--    <div>
                            <a href="#">
                                <strong>Friends</strong>
                                <div> countoffriends</div>
                            </a>
                        </div> -->
                        <!-- <div>
                            <a href="#">
                                <strong>Followers</strong>
                                <div> 2,430</div>
                            </a>
                        </div> -->
                    </div>
                </div>
                <hr class="-mx-4 -mt-1 uk-visible@s">
                <ul>
                    <li>
                    <form action="HomeServlet" method="post" class="createpostform">
                       <button> <a href=""> 
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2H6a2 2 0 01-2-2V6zM14 6a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V6zM4 16a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2H6a2 2 0 01-2-2v-2zM14 16a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z" />
                            </svg> 
                            <span> Home </span> </a> </button>
                       </form>
                    </li>

                    <li>
                        <hr class="my-2">
                    </li>
                     <li>
                        <a href="chat.jsp">
                            <i class="uil-location-arrow"></i>
                            <span> Messages </span> <!-- <span class="nav-tag">showmessagecount</span> --> </a>
                    </li>
                    <li>
                        <hr class="my-2">
                    </li>                 
                </ul> 
                 <form action="DeleteAccServlet" method="post">
                 	<ul style="margin-left: 20px;">
	                    <li>
	                          <button type="submit" name="deleteacc"><i class="fa fa-trash" aria-hidden="true"></i>
	                           <span> Delete Account </span></button>
	                    </li>
	                     <li>
	                        <hr class="my-2">
	                    </li>
	                    
	                    <li>
	                           <button type="submit" name="cleardataacc"><i class="fa fa-remove"></i>
	                           <span>Clear Account Data </span> </button>
	                    </li>
	                    </ul>
                    </form>
                <hr class="my-2">
                <p>Friends</p>
                <div class="divide-gray-300 divide-gray-50 divide-opacity-50 divide-y px-4 dark:divide-gray-800 dark:text-gray-100" style="padding:0px;">
                         <div class="flex items-center justify-between py-3">
                          <tag:forEach var="frndlist" items="${friendslist}">
	                         <div class="frinedprofile" style="width:99%">
		                         <form action="ProfileServlet" class="samedirectform" method="post">
		                              <div class="flex flex-1 items-center space-x-4">
		                                  <a href="profile.jsp" style="display: flex;">
		                                   <img src="assets/images/avatars/defaultpicture.png" class="bg-gray-200 rounded-full w-10 h-10">                                                                             
		                               
		                                        <span class="block capitalize font-semibold" style="margin-left: 10px;
		margin-top: 10px;"> ${frndlist.getFullName()}</span>										 
											  <input type="hidden"  name="getuserid" value="${frndlist.getUserId()}">   
											  <input type="hidden" name="frndid"     value="${frndlist.getFrndId()}">  
											  <input type="hidden" name="frndemail"  value="${frndlist.getEmail()} "> 
											   <input type="hidden" name="frndname"  value="${frndlist.getFullName()} ">                         
		                                
		                                   </a> 
		                              </div>    
		                              </form> 
		                          </div>
			                          <div class="frinedaction">
			                              		<form action="FriendOperationServlet" method="post" style="display: block;"> 
					                             <input type="hidden"  name="getuserfrndid" value="${frndlist.getUserId()}">   
					                                  <button type="submit" name="unfriend" class="bg-pink-500 shadow-sm p-2 pink-500 px-6 rounded-md text-white hover:text-white hover:bg-pink-600" style="margin: 0px 2px 5px 30px; padding:3px;">
					                                    <span style="margin-right:8px;"> <i class="uil-eye-slash  mr-2" style="margin-left: 8px;"></i>Unfriend</span>                                  
					                                 </button>
					                                  <button type="submit" name="block" class="bg-pink-500 shadow-sm p-2 pink-500 px-6 rounded-md text-white hover:text-white hover:bg-pink-600" style="margin: 0px 2px 5px 30px;  padding:3px;">
					                                    <span style="margin-right:8px;"> <i class="uil-stop-circle mr-2" style="margin-left: 8px;"></i>Block</span>                                  
					                                 </button>
					                             </form>     
					                                 <a href="chat.jsp?userId=${frndlist.getUserId()}&name=${frndlist.getFullName()}">
						                                  <button type="submit" name="sendmessage" class="bg-pink-500 shadow-sm p-2 pink-500 px-6 rounded-md text-white hover:text-white hover:bg-pink-600" style="margin: 0px 2px 5px 30px;  padding:3px;">
						                                    <span style="margin-right:8px;"> <i class="fa fa-envelope  mr-2" style="margin-left: 8px;"></i> Send Message</span>                                  
						                                 </button>
						                              </a>
				                  				
			                              </div> 
	                               </tag:forEach>                             
                          </div>
                   </div>
            </div>
            
        </div> 

        <div class="main_content" style="margin-left: 400px;width: calc(90% - 300px);">

            <header>
                <div class="header_inner">
                    <div class="left-side">
                        <!-- Logo -->
                        <div id="logo" class=" uk-hidden@s">
                            <a href="feed.jsp">
                                <img src="assets/images/logo-mobile.png" alt="">
                                <img src="assets/images/logo-mobile-light.png" class="logo_inverse">
                            </a>
                        </div>

                        <div class="triger" uk-toggle="target: #wrapper ; cls: sidebar-active">
                            <i class="uil-bars"></i>
                        </div>

                      <form action="ProfileServlet" method="post" class="searchform">
	                        <div class="header_search">
	                            <input type="text" placeholder="Search.." name="searchtxt">
	                            <div class="icon-search">
	                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
	                                    stroke="currentColor">
	                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
	                                        d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
	                                </svg>
	                            </div>
	                        </div> 
						</form>

                    </div>
                    <div class="right-side lg:pr-4">
                      
                        
                         <!-- Notification -->

                        <a href="#" class="header-links-item">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9" />
                            </svg>
                        </a>
                        <div uk-drop="mode: click;offset: 4" class="header_dropdown">
                            <h4
                                class="-mt-5 -mx-5 bg-gradient-to-t from-gray-100 to-gray-50 border-b font-bold px-6 py-3">
                                Notification </h4>
                            <ul class="dropdown_scrollbar" data-simplebar>
                                <li>
                                    <a href="#">
                                        <div class="drop_avatar"> <img src="assets/images/avatars/defaultpicture.png" alt="">
                                        </div>
                                        <div class="drop_content">
                                            <p> <strong>Show friend Name</strong>  content of notification
                                                <span class="text-link"> content of notifaction  </span>
                                            </p>
                                            <span class="time-ago"> time</span>
                                        </div>
                                    </a>
                                </li>
                       
                               
                            </ul>
                            <a href="#" class="see-all">See all</a>
                        </div>

                        <!-- Messages -->

                        <a href="#" class="header-links-item">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z" />
                            </svg>
                        </a>
                        <div uk-drop="mode: click;offset: 4" class="header_dropdown">
                            <h4
                                class="-mt-5 -mx-5 bg-gradient-to-t from-gray-100 to-gray-50 border-b font-bold px-6 py-3">
                                Messages </h4>
                            <ul class="dropdown_scrollbar" data-simplebar>
                                <li>
                                     <div class="drop_avatar"> <img src="assets/images/avatars/defaultpicture.png" alt="">
                                     </div>
                                     <div class="drop_content">
                                         <strong> friend name</strong> <time> time</time>
                                         <p> msg</p>
                                     </div>
                                </li>
                              
                            </ul>
                            <a href="#" class="see-all">See all</a>
                        </div>

                        <!-- profile -->

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
    
            <div class="container pro-container m-auto">
                
                <!-- profile-cover-->
                <div class="flex lg:flex-row flex-col items-center lg:py-8 lg:space-x-8">

                    <div>
                     
                    </div>


                    <div class="w-20"></div>

                </div>
              
              <!--   <h1 class="lg:text-2xl text-lg font-extrabold leading-none text-gray-900 tracking-tight mt-8"> Create Post </h1> -->
                
                <div class="my-6 grid lg:grid-cols-10  gap-2 hover:text-yellow-700 uk-link-reset">
                        <div class="bg-gray-100 border-4 border-dashed flex flex-col h-full items-center justify-center relative rounded-2xl w-full">                            
                             <form action="CreatePostServlet" method="post" class="createpostform" style="width:98%"><br><br>
	                             <textarea name="postContent" placeholder="Whats on your mind ?"></textarea><br>
	                         	 <input type="hidden" value="ProfileServlet" name="redirectsamepage">
	                              <input type="hidden"  value="<%=session.getAttribute("loginuser") %>" name="profileusername">
	                              <input type="hidden" value="<%=session.getAttribute("loginuserid") %>" name="profileuserid">
	                             <button><i class="text-4xl uil-plus-circle" style="margin-left: 420px;"></i> <span></span></button>
                            </form>
                          
                        </div>
                </div>

                <div class="flex items-center justify-between mt-8 space-x-3">
                    <h1 class="flex-1 font-extrabold leading-none lg:text-2xl text-lg text-gray-900 tracking-tight uk-heading-line"><span></span></h1>
                 
                </div>

   				<tag:forEach var="post" items="${UserPostlist}">
                
				   <div class="my-6 grid  gap-1.5 hover:text-yellow-700 uk-link-reset" style="display: block;margin-bottom: 20px;" >  
                  	 <div class="space-y-5 flex-shrink-0 lg:w-7/12" style="width: 98.333333%;">
                        <div class="bg-white shadow rounded-md dark:bg-gray-900 -mx-2 lg:mx-0" style="width:100%;">
 
                            <div class="flex justify-between items-center px-4 py-3">                                                        	                           											
	                                <div class="flex flex-1 items-center space-x-4">
	                                        <div class="bg-gradient-to-tr from-yellow-600 to-pink-600 p-0.5 rounded-full">  
	                                            <img src="assets/images/avatars/defaultpicture.png" class="bg-gray-200 border border-white rounded-full w-8 h-8">
	                                        </div>
	                                    <span class="block capitalize font-semibold dark:text-gray-100">${post.getFullname()} </span>
	                                </div>                              
                          
                            </div>
    				
	                                      
	                             <div class="py-3 px-4 space-y-3">                               
	                                <div class="flex space-x-4 lg:font-bold" style="display: block;">
	                                 <form action="PostsOperationServlet" method="post" style="display: contents;">
	                                   <textarea style="font-size: 16px;line-height:32px;" name="postcontent" id="editpostcontentid">${post.getContent()}</textarea>                    
	                     
		                                <button type="submit" name="Like" style="margin-right:130px;">
		                                     <span style="margin-right:8px;">${post.getLikes()}</span> <i class="fa fa-thumbs-up" aria-hidden="true"></i>                                   
		                                 </button>
	                               
		                                 <!-- <button type="submit" name="unlike" class="flex items-center space-x-2 flex-1 justify-end">
		                                      <i class="fa fa-thumbs-down"></i>
		                                  </button> -->
	                                 
		                                  <button type="submit" name="edit"  id="maineditbtn" class="" style="margin-right:130px;">
		                                      <i class="fa fa-pencil-square-o"  aria-hidden="true"></i>
		                                   </button>
	                                 
		                                   <button  type="submit" name="delete" style="margin-right:130px;">
		                                      <i class="fa fa-trash-o" aria-hidden="true"></i>
		                                  </button>
	                                 
	                                  	  <button type="submit" name="savepost" style="margin-right:130px;">
		                                     <i class="fa fa-floppy-o" aria-hidden="true"></i>
		                                  </button>
	                                
		                                  	 <input type="hidden" name="email" value="${post.getEmail()}">
			                                 <input type="hidden" name="postid" value="${post.getPostId()}">
			                                 <input type="hidden" name="userid" value="${post.getUserId()}">
		                                    <input type="hidden" name="Redirectsamepage" value="profile.jsp">
	                                     </form>
	                                      <button type="submit" name="edit"  id="tempeditbtn" class="" style="margin-right:130px;">
		                                      <i class="fa fa-pencil-square-o"  aria-hidden="true"></i>
		                                  </button>
	                                </div>
	                            </div>                                 
                        </div>
                    </div>
                </div><!-- here end post div -->
                  </tag:forEach> 
         
            </div>
        </div>
    </div>

        <% 
			String message = (String)request.getAttribute("alertMsg");
			//out.println(message);
			if(message!=null){%>
				<script type="text/javascript">
				    var msg = "<%=message%>";
				    alert(msg);
				</script> 
				
				<%} %>


    <script>
    $(document).ready(function() {
		//disable prop of edit btn   	
    	
    	$("#editpostcontentid").prop("disabled", true);
    	 $("#maineditbtn").hide();
    	
    	$("#tempeditbtn").click(function(){
	    	$("#editpostcontentid").prop("disabled", false);
	    	$("#maineditbtn").show();
	    	$("#tempeditbtn").hide();
    	});

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
    </script>

 <!-- Scripts
    ================================================== -->
    <script src="assets/js/tippy.all.min.js"></script>  
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/uikit.js"></script>
    <script src="assets/js/simplebar.js"></script>
    <script src="assets/js/custom.js"></script>
</body>


<!-- Mirrored from demo.foxthemes.net/instellohtml/profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:22:01 GMT -->
</html>