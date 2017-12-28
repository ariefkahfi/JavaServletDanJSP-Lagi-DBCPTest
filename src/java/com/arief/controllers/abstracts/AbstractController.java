/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.controllers.abstracts;

import com.arief.models.databases.dao.CoursesDAO;
import com.arief.models.entity.Courses;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arief
 */
public abstract class AbstractController extends HttpServlet{
    
    public void requestDispatcherForwardToJSP(
            HttpServletRequest request , 
            HttpServletResponse response,
            String pathOfJSPFile) throws ServletException, IOException{
        getServletContext()
                .getRequestDispatcher(pathOfJSPFile+".jsp")
                .forward(request, response);
    }
    public void sendNotFoundResponse(HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
    public void sendForbiddenResponse(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
    protected void sendRedirect(HttpServletResponse response , String path) throws IOException{
        response.sendRedirect(path);
    }
}
