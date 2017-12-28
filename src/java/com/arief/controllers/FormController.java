/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.controllers;

import com.arief.controllers.abstracts.AbstractController;
import com.arief.controllers.abstracts.ResponseSender;
import com.arief.models.databases.dao.CoursesDAO;
import com.arief.models.databases.dao.StudentCoursesDAO;
import com.arief.models.databases.dao.StudentDAO;
import com.arief.models.entity.Courses;
import com.arief.models.entity.Student;
import com.arief.models.entity.StudentCourses;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arief
 */
@WebServlet(urlPatterns = {"/form/*"} , name = "FormServletController")
public class FormController extends AbstractController{

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        switch(pathInfo){
            case "/student" :
                requestDispatcherForwardToJSP(req, resp, "/WEB-INF/views/forms/student");
                break;
            case "/courses" :
                requestDispatcherForwardToJSP(req, resp, "/WEB-INF/views/forms/courses");
                break;
            case "/student-courses":
                requestDispatcherForwardToJSP(req, resp, "/WEB-INF/views/forms/student-courses");
                break;
            default:
                sendNotFoundResponse(resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        
        Map<String,Object> paramMap  = new HashMap<>();
        
        switch(pathInfo) {
            case "/student" :
                paramMap.put("name", req.getParameter("name"));
                paramMap.put("gender", req.getParameter("gender"));
                processRequestForStudentParameter(paramMap, resp, new ResponseSender() {
                    
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response, String shortMessage) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(500);
                        response.getWriter().write("Error : " +shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(200);
                        response.getWriter().write((String)data);
                    } 
                });
                break;
            case "/courses":
                paramMap.put("id", req.getParameter("id"));
                paramMap.put("name", req.getParameter("name"));
                processRequestForCoursesParameter(paramMap, resp, new ResponseSender() {   
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response,String shortMessage) throws IOException{
                        response.setContentType("text/plain");
                        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        response.getWriter().write("Error : " + shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(200);
                        response.getWriter().write((String)data);
                    }
                });
                break;
            case "/student-courses":
                paramMap.put("student_id", Integer.parseInt(req.getParameter("student_id")));
                paramMap.put("courses_id", req.getParameter("courses_id"));
                processRequestForStudentCourseParameter(paramMap, resp, new ResponseSender() {
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response, String shortMessage) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(500);
                        response.getWriter().write(shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(200);
                        response.getWriter().write((String)data);
                    }
                });
                break;
            case "/update/courses":
                paramMap.put("_courses_id", req.getParameter("_courses_id"));
                paramMap.put("_courses_name", req.getParameter("_courses_name"));
                processRequestForCoursesUpdateParameter(paramMap, resp, new ResponseSender() {
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response, String shortMessage) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(500);
                        response.getWriter().write(shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(200);
                        response.getWriter().write((String)data);
                    }
                 });
                break;
            case "/update/student":
                paramMap.put("_student_id", req.getParameter("_student_id"));
                paramMap.put("_student_name", req.getParameter("_student_name"));
                paramMap.put("_student_gender", req.getParameter("_student_gender"));
                
                processRequestForStudentUpdateParameter(paramMap, resp, new ResponseSender() {
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response, String shortMessage) throws IOException {
                       response.setContentType("text/plain");
                       response.setStatus(500);
                       response.getWriter().write(shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(200);
                        response.getWriter().write((String)data);
                    }
                });      
                break;
            default:
                sendNotFoundResponse(resp);
                break;
        }
    }
    
    private void processRequestForStudentUpdateParameter(
            Map<String,Object> paramMap,
            HttpServletResponse response,
            ResponseSender responseSender
    )throws IOException{
        int updatedStudentId = (int)paramMap.get("_student_id");
        String updatedStudentName = (String)paramMap.get("_student_name");
        String updatedStudentGender = (String)paramMap.get("_student_gender");
        
        StudentDAO studentDAO = (StudentDAO)getServletContext().getAttribute("studentDAO");
        
        try {
            studentDAO.update(new Student(updatedStudentId, updatedStudentName, updatedStudentGender));
            responseSender.sendResponseWithData(response, "RESPONSE_OK");
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, ex.getMessage());
            responseSender.sendErrorResponseForSqlError(response, ex.getMessage());
        }
    }
    private void processRequestForCoursesUpdateParameter(
            Map<String,Object> paramMap,
            HttpServletResponse respose ,
            ResponseSender responseSender
    )throws IOException{
        String updatedCoursesId = (String)paramMap.get("_courses_id");
        String updatedCoursesName = (String)paramMap.get("_courses_name");
        
        CoursesDAO courseDAO = (CoursesDAO)getServletContext().getAttribute("courseDAO");
        
        try {
            courseDAO.update(new Courses(updatedCoursesId, updatedCoursesName));
            responseSender.sendResponseWithData(respose, "RESPONSE_OK");
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, ex.getMessage());
            responseSender.sendErrorResponseForSqlError(respose, "Error : " +ex.getMessage());
        }
        
    }
    private void processRequestForStudentCourseParameter(
            Map<String,Object> paramMap,
            HttpServletResponse response,
            ResponseSender responseSender
    )throws IOException{
        String coursesId = (String) paramMap.get("courses_id");
        int studentId = (int) paramMap.get("student_id");
        
        StudentCourses sc = new StudentCourses(studentId, coursesId);
        
        StudentCoursesDAO scDAO = (StudentCoursesDAO)getServletContext().getAttribute("studentCoursesDAO");
        
        
        try {
            boolean saveRelation = scDAO.saveRelation(sc);
            String s ;
            if(saveRelation){
                s = "save";
            }else{
                s = "not_save";
            }
            responseSender.sendResponseWithData(response, s);
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE,ex.getMessage());
            responseSender.sendErrorResponseForSqlError(response, "Error : " + ex.getMessage());
        }
    }
    private void processRequestForStudentParameter(
            Map<String,Object> paramMap,
            HttpServletResponse response,
            ResponseSender responseSender
    )throws IOException{
        String name = (String)paramMap.get("name");
        String gender = (String)paramMap.get("gender");
        
        Student s = new Student(name, gender);
        
        StudentDAO studentDAO = (StudentDAO)getServletContext().getAttribute("studentDAO");
        
        try {
            studentDAO.save(s);
            responseSender.sendResponseWithData(response,"RESPONSE_OK");
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).info(ex.getMessage());
            responseSender.sendErrorResponseForSqlError(response, ex.getMessage());
        }
        
    }
    
    private void processRequestForCoursesParameter(
            Map<String,Object> paramMap,
            HttpServletResponse response ,
            ResponseSender responseSender
    ) throws IOException{
        String id = (String)paramMap.get("id");
        String name = (String)paramMap.get("name");
        Courses c = new Courses(id, name);
        
        CoursesDAO courseDAO = (CoursesDAO)getServletContext().getAttribute("courseDAO");
        
        try {
            courseDAO.save(c);
            responseSender.sendResponseWithData(response,"RESPONSE_OK");
        } catch (SQLException ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, ex.getMessage());
            responseSender.sendErrorResponseForSqlError(response,ex.getMessage());
        }

        
       
    }
    
}
