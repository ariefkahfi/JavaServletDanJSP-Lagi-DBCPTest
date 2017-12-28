<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
    import="com.arief.consts.PathConstant"
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%--Required CSS--%>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/navbar.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/responsive.css"/>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/global.css"/>
        <!--<link href="https://use.fontawesome.com/releases/v5.0.2/css/all.css" rel="stylesheet"/>-->
        <!--<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"/>--> 
        <%--Required CSS--%>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/form.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/courses-form.css"/>
        
    </head>
    <body>
        <%@include file="../../../assets/html/navbar.html" %>
        
        
        
        <div id="courses-form-container">
            <h3 id="courses-form-container-title">Courses Form</h3>
            <div class="form-wrapper">
                <div class="form-row clearfix">
                    <label class="form-label" for="courses_id">Courses ID</label>
                    <input type="text" class="form-input-text" id="courses_id"/>
                </div>
                <div class="form-row clearfix">
                    <label class="form-label" for="courses_name">Courses Name</label>
                    <input type="text" class="form-input-text" id="courses_name"/>
                </div>
                <div class="form-row clearfix">
                    <input type="submit" class="form-button-blue" onclick="saveCourseRequest()" value="Save Courses"/>
                </div>
            </div>
        </div>
        
    </body>
    <script src="<%=PathConstant.CP%>/assets/js/xhr/base-request.js"></script>
    <script src="<%=PathConstant.CP%>/assets/js/forms/courses.js"></script>
</html>
