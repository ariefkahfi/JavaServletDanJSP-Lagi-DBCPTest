/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.listeners;

import com.arief.models.databases.ConnectionFactory;
import com.arief.models.databases.dao.CoursesDAO;
import com.arief.models.databases.dao.StudentCoursesDAO;
import com.arief.models.databases.dao.StudentCoursesJoinDAO;
import com.arief.models.databases.dao.StudentDAO;
import com.arief.models.databases.dao.impl.CoursesDAOImpl;
import com.arief.models.databases.dao.impl.StudentCoursesDAOImpl;
import com.arief.models.databases.dao.impl.StudentCoursesJoinDAOImpl;
import com.arief.models.databases.dao.impl.StudentDAOImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author arief
 */
public class MyServletContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(MyServletContextListener.class.getName());
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("Context initialized .....");
        try {
            LOGGER.info("prepare for ConnectionFactory bean ....");
            
            ConnectionFactory connFact = new ConnectionFactory();
            
            LOGGER.info("prepare for CoursesDAO bean ....");
            CoursesDAO courseDAO = new CoursesDAOImpl(connFact.getConnectionInstance());
            
            LOGGER.info("prepare for StudentDAO bean ....");
            StudentDAO studentDAO = new StudentDAOImpl(connFact.getConnectionInstance());
            
            LOGGER.info("prepare for StudentCoursesDAO bean ....");
            StudentCoursesDAO studentCoursesDAO = new StudentCoursesDAOImpl(connFact.getConnectionInstance());
            
            LOGGER.info("prepare for StudentCoursesJoinDAO bean ....");
            StudentCoursesJoinDAO studentCoursesJoinDAO = new StudentCoursesJoinDAOImpl(connFact.getConnectionInstance());
            
            
            LOGGER.info("injecting studentCoursesJoinDAO bean to servletContextAttribute ....");
            sce.getServletContext().setAttribute("studentCoursesJoinDAO", studentCoursesJoinDAO);
            
            LOGGER.info("injecting studentCoursesDAO bean to servletContextAttribute ....");
            sce.getServletContext().setAttribute("studentCoursesDAO", studentCoursesDAO);
            
            LOGGER.info("injecting courseDAO bean to servletContextAttribute .....");
            sce.getServletContext().setAttribute("courseDAO", courseDAO);
            
            LOGGER.info("injecting studentDAO bean to servletContextAttribute ....");
            sce.getServletContext().setAttribute("studentDAO", studentDAO);
            
        } catch (SQLException ex) {
            Logger.getLogger(MyServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Context destroyed .....");
    }
    
}
