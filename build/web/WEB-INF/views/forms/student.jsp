<%@page import="com.arief.consts.PathConstant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Form Page</title>
        
        <%--Required CSS--%>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/navbar.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/responsive.css"/>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/global.css"/>
        <link href="https://use.fontawesome.com/releases/v5.0.2/css/all.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"/> 
        <%--Required CSS--%>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/form.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/student-form.css"/>
        
        
    </head>
    <body>
        <%@include file="../../../assets/html/navbar.html" %>
        
        
        <div id="student-container">
            
            <div class="student-container-inner">
                <h3 class="student-container-inner-title">Courses Form</h3>
                <div class="student-container-inner-content-container">
                    <a class="student-container-inner-a" href="<%=PathConstant.CP%>/form/courses">Go to this page</a>
                </div>
            </div>
            
            <div class="student-container-inner">
                <h3 class="student-container-inner-title">Courses List</h3>
                <div class="student-container-inner-content-container">
                    <a class="student-container-inner-a" href="<%=PathConstant.CP%>/list/courses">Go to this page</a>
                </div>
            </div>
            
            <div class="student-container-inner">
                <h3 class="student-container-inner-title">Student List</h3>
                <div class="student-container-inner-content-container">
                    <a class="student-container-inner-a" href="<%=PathConstant.CP%>/list/student">Go to this page</a>
                </div>
            </div>
            
        </div>
        
        <div id="student-form-container">
            <h3 id="student-form-container-title">Student Form</h3>
            
            <div class="form-wrapper">
                
                <div class="form-row clearfix">
                    <label class="form-label" for="student_name">Student Name</label>
                    <input class="form-input-text" type="text" id="student_name" name="student_gender"/>
                </div>
                
                <div class="form-row clearfix">
                    <label class="form-label" for="student_gender">Student Gender</label>
                    <div class="form-input-radio-container" id="student_gender">
                        <div class="form-input-radio-wrapper">
                            <input type="radio" class="form-input-radio" name="student_gender" value="Male"/>Male
                        </div>
                        <div class="form-input-radio-wrapper">
                            <input type="radio" class="form-input-radio" name="student_gender" value="Female"/>Female
                        </div>
                    </div>
                </div>
                
                <div class="form-row">
                    <input type="submit" value="Save Student" onclick="saveStudent()" class="form-button-blue"/>
                </div>
                
            </div>
            
        </div>
        
        
        
        
    </body>
    <script src="<%=PathConstant.CP%>/assets/js/xhr/base-request.js"></script>
    <script src="<%=PathConstant.CP%>/assets/js/forms/student.js"></script>
</html>
