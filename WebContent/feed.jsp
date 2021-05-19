<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html lang="en">
<!-- Mirrored from demo.foxthemes.net/instellohtml/feed.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:20:22 GMT -->
<head>
 	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="./bootstrap/Jquery/jquery-3.6.0.min.js">  </script>   
	
	<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
   
    <link href="assets/images/favicon.png" rel="icon" type="image/png">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    
    <title>Soical Spark</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Instello - Sharing Photos platform HTML Template">


    <link rel="stylesheet" href="assets/css/icons.css">
    <link rel="stylesheet" href="assets/css/uikit.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/tailwind.css">

</head>

<body>


    <div id="wrapper">

        <div class="sidebar" style="width:360px;">
            <div class="sidebar_header border-b border-gray-200 from-gray-100 to-gray-50 bg-gradient-to-t  uk-visible@s"> 
                <a href="#">
                  <img src="assets/images/favicon.png" style="display:inline">
                  <img src="assets/images/favicon.png" class="logo_inverse"><span style="color: #be185d;">Social Spark</span>
                </a>
                <!-- btn night mode -->
                <a href="#" id="night-mode" class="btn-night-mode" data-tippy-placement="left" title="Switch to dark mode"></a>
            </div>
            <div class="border-b border-gray-20 flex justify-between items-center p-3 pl-5 relative uk-hidden@s">
                <h3 class="text-xl"> Navigation </h3>
                <span class="btn-mobile" uk-toggle="target: #wrapper ; cls: sidebar-active"></span>
            </div>
            <div class="sidebar_inner" data-simplebar>
                  <!-- <div class="flex flex-col items-center my-6 uk-visible@s">
                  <div
                        class="bg-gradient-to-tr from-yellow-600 to-pink-600 p-1 rounded-full transition m-0.5 mr-2  w-24 h-24">
                        <img src="assets/images/avatars/defaultpicture.png"
                            class="bg-gray-200 border-4 border-white rounded-full w-full h-full">
                    </div>
                    <a href="profile.jsp" class="text-xl font-medium capitalize mt-4 uk-link-reset">${loginuser}</a>
                </div> -->
                <hr class="-mx-4 -mt-1 uk-visible@s">
                <ul>
                    <li>
                        <a href="ProfileServlet">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                    d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
                            </svg>
                            <span>${loginuser}</span> </a>
                    </li>
                    <li>
                        <hr class="my-2">
                    </li>
                  
                </ul>
                   <!-- right sidebar-->
                    <div class="lg:w-5/12" style="width:98%;">

                        <div class="bg-white dark:bg-gray-900 shadow-md rounded-md overflow-hidden">

                            <div class="bg-gray-50 dark:bg-gray-800 border-b border-gray-100 flex items-baseline justify-between py-4 px-6 dark:border-gray-800">
                                <h2 class="font-semibold text-lg">Suggested Friends</h2>
                               <!--  <a href="#"> Refresh</a> -->
                            </div>
                           
                  <div class="divide-gray-300 divide-gray-50 divide-opacity-50 divide-y px-4 dark:divide-gray-800 dark:text-gray-100">
                                <div class="flex items-center justify-between py-3">
                                
                                    <div class="flex flex-1 items-center space-x-4">
                                    
                                    <form action="FriendOperationServlet" class="friendsform" method="post">
                                       <div class="flex flex-col">
                                        
                                         	<tag:forEach var="allsuggestionfriend" items="${FriendSugestionList}">
	                                            <a href="profile.jsp">
	                                            <img src="assets/images/avatars/defaultpicture.png" class="bg-gray-200 rounded-full w-10 h-10">
	                                        	</a>
	                                            <span class="block capitalize font-semibold"> ${allsuggestionfriend.getFirstName()}  ${allsuggestionfriend.getLastName()}</span>
	                                        	<input type="hidden" value="${allsuggestionfriend.getFirstName()}" name="hiddenUserNameId">
	                                        	<input type="hidden" value="${allsuggestionfriend.getUserId()}" name="hiddenUserId">
	                                         	<input type="hidden" value="ProfileServlet" name="redirectsamepage">
	                                        	<button class="border border-gray-200 font-semibold px-4 py-1 rounded-full hover:bg-pink-600
	                                        			 hover:text-white hover:border-pink-600 dark:border-gray-800" style="border: 1px solid;"> Add Friend
				                                </button>
                                       
                                        	 </tag:forEach>                                                                                 
                                         </div>  
                                         </form>
                                    </div>                                                                   	
                                </div>
                            </div> 
                        </div>

                    </div>
            </div>
        </div>

        <div class="main_content" style="margin-left: 400px;width: calc(90% - 300px);">

            <header>
                <div class="header_inner">
                    <div class="left-side">
                    	<form action="" method="post" class="searchform">
	                        <div class="header_search">
	                            <input type="text" placeholder="Search.." name="searchtxt" id="txtsearchid" style="border: 1px solid; border-color: #e5e7eb;    width: 270px; ">
	                            <div class="icon-search" style="margin-left: 0px;">
	                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
	                                    stroke="currentColor">
	                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
	                                        d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
	                                </svg>
	                            </div>
	                        </div> 
						</form>
						
						<!-- here show search result -->
						<span style="margin-left:10px;">Ajax Response</span>
						<div id="ajaxGetUserServletResponse"></div>
						
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
                             <tag:forEach var="getnotf" items="${getNotificationslist}">
                                <li>
                                    <a href="#">
                                        <div class="drop_avatar"> <img src="assets/images/avatars/defaultpicture.png" alt="">
                                        </div>
                                        <div class="drop_content">
                                          
                                            <tag:if test="${getnotf.getType()=='1'}">  <!--  here check condition 1 for notification , 2 for message -->
												<h1 class="sub-heading"><strong>${getnotf.getTouserName()}</strong></h1>
												<p>sent friend request to you..!!</p>
												<form  action="FriendOperationServlet" class="friendsoperation" method="post">
													<button type="submit" name="accept" class="bg-gradient-to-br from-pink-500 py-3 rounded-md text-white text-xl to-red-400 w-full" style="width:30%;line-height: 5px; height: 5px;font-size: 10px;padding: 0px;">Accept</button>
													<button type="submit" name="reject" class="bg-gradient-to-br from-pink-500 py-3 rounded-md text-white text-xl to-red-400 w-full" style="width:30%;line-height: 5px; height: 5px;font-size: 10px;padding: 0px;">Reject</button>
												</form>
												
											</tag:if>
                                        </div>
                                    </a>
                                </li>
                         </tag:forEach>  
                               
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
                                    <a href="#">
                                        <div class="drop_avatar"> <img src="assets/images/avatars/avatar-1.jpg" alt="">
                                        </div>
                                        <div class="drop_content">
                                            <strong> UserName</strong> 
                                            <p> Lorem ipsum dolor sit amet, consectetur </p>
                                        </div>
                                    </a>
                                </li>
                              
                            </ul>
                            <a href="#" class="see-all">See all</a>
                        </div>

                        <!-- profile -->

                        <a href="#">
                            <img src="assets/images/avatars/defaultpicture.png" class="header-avatar" alt="">
                        </a>
                        <div uk-drop="mode: click;offset:9" class="header_dropdown profile_dropdown border-t">
                            <ul>
                                 <ul>
                                <li><a href="ChangePassword.jsp"> Change Password</a> </li>
                                <li><a href="LogoutServlet">Log Out</a></li>
                            </ul>
                            </ul>
                        </div>

                    </div>
                </div>
            </header>

            <div class="container m-auto">

                <h1 class="lg:text-2xl text-lg font-extrabold leading-none text-gray-900 tracking-tight mb-5"> Feed </h1>
<strong>Ajax Response</strong>:
	<div id="ajaxGetUserServletResponse"></div>

                <div class="lg:flex justify-center lg:space-x-10 lg:space-y-0 space-y-5" style="display: block;">
                
                <tag:forEach var="userallpost" items="${allUserPostlist}">
                
				   <div class="my-6 grid  gap-1.5 hover:text-yellow-700 uk-link-reset" style="display: block;margin-bottom: 20px;" >  
                  	 <div class="space-y-5 flex-shrink-0 lg:w-7/12" style="width: 98.333333%;">
                        <div class="bg-white shadow rounded-md dark:bg-gray-900 -mx-2 lg:mx-0" style="width:100%;">
 
                            <div class="flex justify-between items-center px-4 py-3">                                                        	                           											
	                                <div class="flex flex-1 items-center space-x-4">
	                                        <div class="bg-gradient-to-tr from-yellow-600 to-pink-600 p-0.5 rounded-full">  
	                                            <img src="assets/images/avatars/defaultpicture.png" class="bg-gray-200 border border-white rounded-full w-8 h-8">
	                                        </div>
	                                    <span class="block capitalize font-semibold dark:text-gray-100">${userallpost.getFullname()} </span>
	                                </div>                              
                          
                            </div>
    				
	                             <div class="py-3 px-4 space-y-3">                               
	                                <div class="flex space-x-4 lg:font-bold" style="display: block;">
	                                 <form action="PostsOperationServlet" method="post" style="display: contents;">
	                                  <textarea style="font-size: 16px;line-height:32px;" name="postcontent" id="editposttxtid">${userallpost.getContent()} </textarea>                    
	                     
		                                <button type="submit" name="Like" class="" style="margin-right:130px;">
		                                    <span style="margin-right:8px;">${userallpost.getLikes()}</span> <i class="fa fa-thumbs-up" aria-hidden="true"></i>                                   
		                                 </button>
	                               
		                                 <button type="submit" name="unlike" class="" style="margin-right:130px;">
		                                      <i class="fa fa-thumbs-down"></i>
		                                  </button>
		                                  
	                                   		<!-- <button type="submit" name="edit"  id="maineditbtn" class="" style="margin-right:130px;">
		                                      <i class="fa fa-pencil-square-o"  aria-hidden="true"></i>
		                                   </button> -->
		                                 
	                                 
		                                   <button  type="submit" name="delete" class="" style="margin-right:130px;">
		                                      <i class="fa fa-trash-o" aria-hidden="true"></i>
		                                  </button>
	                                 
	                                  	  <button type="submit" name="savepost" class="" style="margin-right:130px;">
		                                     <i class="fa fa-floppy-o" aria-hidden="true"></i>
		                                  </button>
	                                
		                                  	<input type="hidden" name="email" value="${userallpost.getEmail()}">
		                                    <input type="hidden" name="postid" value="${userallpost.getPostId()}">
		                                    <input type="hidden" name="userid" value="${userallpost.getUserId()}">
		                                    <input type="hidden" name="Redirectsamepage" value="feed.jsp">
	                                     </form>
	                                     
	                                    <!--   <button type="submit" name="edit"  id="tempeditbtn" class="" style="margin-right:130px;">
		                                      <i class="fa fa-pencil-square-o"  aria-hidden="true"></i>
		                                  </button> -->
	                                </div>
	                            </div>                                 
                        </div>
                    </div>
                </div><!-- here end post div -->
                  </tag:forEach>    

                 

                </div>               
          

            </div>

        </div>

    </div>

<% 
			String message = (String)request.getAttribute("msg");
			//out.println(message);
			if(message!=null){%>
				<script type="text/javascript">
				    var msg = "<%=message%>";
				    alert(msg);
				</script> 
				
				<%} %>



    <script>
    $(document).ready(function() {

 	//send ajax to find user
    	 $('#txtsearchid').blur(function(event) {
             var searchname = $('#txtsearchid').val();
             $.get('SearchUserServlet', {
            	 searchname : searchname
             }, function(responseText) {
                     $('#ajaxGetUserServletResponse').text(responseText);
             });
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


<!-- Mirrored from demo.foxthemes.net/instellohtml/feed.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 24 Apr 2021 15:21:12 GMT -->
</html>