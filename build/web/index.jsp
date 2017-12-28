<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Home Page</title>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/index.css"/>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/navbar.css"/>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/left-content.css"/>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/responsive.css"/>
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/global.css"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"/> 
    </head>
    <body>
        <%@include file="assets/html/navbar.html" %>
        <%@include file="assets/html/left-content.html" %>
        
        
        <div class="right-container">
            
            <div class="container-r">
                <h3 class="container-title">Form Student</h3>
                <div class="inner-container">
                    <a class="inner-container-a" href="form/student">Go to this page</a>
                </div>
            </div>
            
            <div class="container-r">
                <h3 class="container-title">Form Courses</h3>
                <div class="inner-container">
                    <a class="inner-container-a" href="form/courses">Go to this page</a>
                </div>
            </div>
            
            <div class="container-r">
                <h3 class="container-title">List Student</h3>
                <div class="inner-container">
                    <a class="inner-container-a" href="list/student">Go to this page</a>
                </div>
            </div>
            
            <div class="container-r">
                <h3 class="container-title">List Courses</h3>
                <div class="inner-container">
                    <a class="inner-container-a" href="list/courses">Go to this page</a>
                </div>
            </div>
            
            <div class="container-r">
                <h3 class="container-title">Get a course for student</h3>
                <div class="inner-container">
                    <a class="inner-container-a" href="form/student-courses">Go to this page</a>
                </div>
            </div>
            
            <div class="container-r">
                <h3 class="container-title">List all student with their courses</h3>
                <div class="inner-container">
                    <a class="inner-container-a" href="list/student-courses">Go to this page</a>
                </div>
            </div>
            
        </div>
        
    </body>
</html>
