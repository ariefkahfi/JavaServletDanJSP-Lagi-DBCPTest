<%@page import="com.arief.models.entity.StudentCoursesJoin"%>
<%@page import="com.arief.models.databases.dao.StudentCoursesJoinDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.arief.consts.PathConstant"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student who had joint courses page</title>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/student-courses-list.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/global.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/responsive.css"/>
        <link rel="stylesheet" href="<%=PathConstant.CP%>/assets/css/navbar.css"/>
    </head>
    <body>
        <%@include file="../../../assets/html/navbar.html" %>
        
        <div id="student-courses-container">
            <h3 id="student-courses-container-title">List of student who had joint in courses</h3>
            <div id="student-courses-container-inner">
                <table border="2" class="table-data">
                    <tr>
                        <td>Courses Name</td>
                        <td>Student Name</td>
                    </tr>
                    <%
                        StudentCoursesJoinDAO scJoinDAO = (StudentCoursesJoinDAO)getServletContext().getAttribute("studentCoursesJoinDAO");
                        for(StudentCoursesJoin scJoin : scJoinDAO.findAllOnlyCoursesNameAndStudentName()){
                            out.println("<tr>");
                                out.println("<td>" +scJoin.getCoursesName() + "</td>");
                                out.println("<td>" +scJoin.getStudentName() + "</td>");
                            out.println("</tr>");
                        }
                    %>
                </table>
            </div>
        </div>
        
    </body>
    <script src="<%=PathConstant.CP%>/assets/js/list/student-courses.js"></script>
</html>
