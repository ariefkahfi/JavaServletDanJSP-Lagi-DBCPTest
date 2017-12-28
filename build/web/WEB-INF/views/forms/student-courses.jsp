<%@page contentType="text/html" pageEncoding="UTF-8" import="com.arief.consts.PathConstant"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get a course for student</title>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/global.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/navbar.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/form.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/responsive.css"/>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/student-courses-form.css"/>
        
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"/> 
    </head>
    <body>
        <%@include file="../../../assets/html/navbar.html" %>
        
        <div id="student-courses-container">
            <h3 id="student-courses-container-title">Get a course for student</h3>
            <div class="form-wrapper">
                <div class="form-row clearfix">
                    <label class="form-label" for="select_student_id">Student ID</label>
                    <select class="form-select" id="select_student_id">
                        
                    </select>
                </div>
                
                <div class="form-row clearfix">
                    <label class="form-label" for="select_courses_id">Courses ID</label>
                    <select class="form-select" id="select_courses_id">
                        
                    </select>
                </div>
                
                <div class="form-row">
                    <button class="form-button-blue" onclick="saveStudentCourses()">Get a course</button>
                </div>
                
            </div>
        </div>
        
    </body>
    <script src="<%=PathConstant.CP%>/assets/js/xhr/base-request.js"></script>
    <script src="<%=PathConstant.CP%>/assets/js/forms/student-courses.js"></script>
</html>
