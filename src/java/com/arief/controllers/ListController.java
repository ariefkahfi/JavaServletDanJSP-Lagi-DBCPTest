package com.arief.controllers;

import com.arief.controllers.abstracts.AbstractController;
import com.arief.controllers.abstracts.ResponseSender;
import com.arief.models.databases.dao.CoursesDAO;
import com.arief.models.databases.dao.StudentDAO;
import com.arief.models.entity.Courses;
import com.arief.models.entity.Student;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/list/*"},name = "ListServletController")
public class ListController extends AbstractController{

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        switch(pathInfo){
            case "/student" :
                requestDispatcherForwardToJSP(
                        req, 
                        resp, 
                        "/WEB-INF/views/lists/student");
                break;
            case "/courses" :
                requestDispatcherForwardToJSP(
                        req, 
                        resp, 
                        "/WEB-INF/views/lists/courses");
                break;
            case "/student-courses":
                requestDispatcherForwardToJSP(req, resp, "/WEB-INF/views/lists/student-courses");
                break;
            case "/get/student-courses":
                
                break;
            case "/get/student" :
                processRequestToJsonArrForStudent(resp, new ResponseSender() {
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response, String shortMessage) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(500);
                        response.getWriter().write(shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("application/json");
                        response.setStatus(200);
                        response.getWriter().write((String)data);
                    }
                });
                break;
            case "/get/courses" :
                processRequestToJsonArrForCourses(resp, new ResponseSender() {
                    @Override
                    public void sendErrorResponseForSqlError(HttpServletResponse response, String shortMessage) throws IOException {
                        response.setContentType("text/plain");
                        response.setStatus(500);
                        response.getWriter().write(shortMessage);
                    }

                    @Override
                    public void sendResponseWithData(HttpServletResponse response, Object data) throws IOException {
                        response.setContentType("application/json");
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
    
    private void processRequestToJsonArrStudentCourses(HttpServletResponse response ,ResponseSender sender)
    throws IOException{
        
    }
    private void processRequestToJsonArrForCourses(HttpServletResponse response , ResponseSender responseSender) throws IOException{
        CoursesDAO coursesDAO = (CoursesDAO)getServletContext().getAttribute("courseDAO");
        
        try {
            List<Courses> data = coursesDAO.getCourses();
            String jsonArr = new Gson().toJson(data);
            responseSender.sendResponseWithData(response, jsonArr);
        } catch (SQLException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, ex.getMessage());
            responseSender.sendErrorResponseForSqlError(response, ex.getMessage());
        }
        
    }
    private void processRequestToJsonArrForStudent(HttpServletResponse response , ResponseSender responseSender) throws IOException{
        StudentDAO studentDAO = (StudentDAO)getServletContext().getAttribute("studentDAO");
        
        try {
            List<Student> data = studentDAO.getStudentList();
            String jsonArr = new Gson().toJson(data);
            responseSender.sendResponseWithData(response, jsonArr);
        } catch (SQLException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, ex.getMessage());
            responseSender.sendErrorResponseForSqlError(response, ex.getMessage());
        }
    }
    
}
