<%@page import="com.arief.models.entity.Courses"%>
<%@page import="com.arief.models.databases.dao.CoursesDAO"%>
<%@page import="com.arief.consts.PathConstant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses List Page</title>
        
        <%--Required CSS--%>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/navbar.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/responsive.css"/>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/global.css"/>
        <link href="https://use.fontawesome.com/releases/v5.0.2/css/all.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"/> 
        <%--Required CSS--%>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/form.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/courses-lists.css"/>
        
    </head>
    <body>
        <%@include file="../../../assets/html/navbar.html" %>
        
        <div id="courses-update-form-container">
            <h3 id="courses-update-form-container-title">Update Form</h3>
            <div id="courses-update-form-container-inner" class="form-wrapper">
                <div class="form-row clearfix">
                    <label for="_courses_id" class="form-label">Courses ID</label>
                    <input type="text" id="_courses_id" readonly="readonly"  class="form-input-text"/>
                </div>
                <div class="form-row clearfix">
                    <label for="_courses_name" class="form-label">Courses Name</label> 
                    <input type="text" id="_courses_name"  class="form-input-text"/>
                </div>
                <div class="form-row">
                    <button class='form-button-blue' onclick="submitUpdate()">Update Data</button>
                </div>
            </div>
        </div>
        
        <div id="courses-list-container">
            <h3 id="courses-list-container-title">Courses List</h3>
            <div id="courses-list-container-inner">
                <table border="2" class="table-data">
                    <tr>
                        <td>Courses ID</td>
                        <td>Courses Name</td>
                        <td>Update</td>
                    </tr>
                    <%
                        CoursesDAO coursesDAO = (CoursesDAO)getServletContext().getAttribute("courseDAO");
                    %>
                    <%
                        for(Courses c : coursesDAO.getCourses()){
                    %>
                            <tr>
                                <td><%=c.getId()%></td>
                                <td><%=c.getName()%></td>
                                <td><button onclick="updateData('<%=c.getId()%>','<%=c.getName()%>')">Update</button></td>
                            </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        
    </body>
    <script src="<%=PathConstant.CP%>/assets/js/xhr/base-request.js"></script>
    <script src="<%=PathConstant.CP%>/assets/js/list/courses.js"></script>
</html>
