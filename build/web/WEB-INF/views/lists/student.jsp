<%@page import="com.arief.models.databases.dao.StudentDAO"%>
<%@page import="com.arief.models.entity.Student"%>
<%@page import="com.arief.consts.PathConstant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List Page</title>
        
        <%--Required CSS--%>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/navbar.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/responsive.css"/>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/global.css"/>
        <link href="https://use.fontawesome.com/releases/v5.0.2/css/all.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet"/> 
        <%--Required CSS--%>
        
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/student-lists.css"/>
        
    </head>
    <body>
        <%@include file="../../../assets/html/navbar.html" %>
        
        
        
        <div id="student-list-container">
            <h3 id="student-list-container-title">Student List</h3>
            <div id="student-list-container-inner">
                <table border="2" class="table-data">
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Gender</td>
                    </tr>
                    <%
                          StudentDAO studentDAO = (StudentDAO)getServletContext().getAttribute("studentDAO");
                          for(Student s : studentDAO.getStudentList()){
                              out.println(
                                      "<tr>"
                                              + "<td>" +s.getId()+ "</td>"
                                              + "<td>" +s.getName()+ "</td>"
                                              + "<td>" +s.getGender()+ "</td>"
                                              + "</tr>"
                              );
                          }
                    %>
                </table>
            </div>
        </div>
        
    </body>
</html>
