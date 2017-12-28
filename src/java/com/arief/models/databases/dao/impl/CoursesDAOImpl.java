/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.databases.dao.impl;

import com.arief.models.databases.dao.CoursesDAO;
import com.arief.models.entity.Courses;
import com.arief.utils.MyLoggerApp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arief
 */
public class CoursesDAOImpl implements CoursesDAO{

    private final Connection con;
    private final MyLoggerApp loggerApp;


    public CoursesDAOImpl(Connection con) {
        this.con = con;
        loggerApp = new MyLoggerApp(CoursesDAOImpl.class.getName());
        loggerApp.doLogInfo("construct CoursesDAOImpl", "CoursesDAOImpl()", "called ....");
    }
    
    
    @Override
    public void save(Courses c)throws SQLException{
        
            PreparedStatement pst = con.prepareStatement("insert into courses values (?,?)");
            
            pst.setString(1, c.getId());
            pst.setString(2, c.getName());
            
            int rowsAffected = pst.executeUpdate();

            loggerApp.doLogInfo("save_courses", "save()", String.valueOf(rowsAffected));

    }

    @Override
    public List<Courses> getCourses() throws SQLException{
        List<Courses> data = new ArrayList<>();
       
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from courses");
            while (rs.next()) {                
                data.add(new Courses(rs.getString("id"), rs.getString("name")));
            }
            loggerApp.doLogInfo("get_courses", "getCourses()", "fetching data from courses table");
            return data;
       
    }

    @Override
    public void delete(String coursesId) throws SQLException{
        // not implemented yet ....
    }

    @Override
    public void update(Courses updatedCourses) throws SQLException{
        
            PreparedStatement pst = con.prepareStatement("update courses c set c.name = ? where c.id = ?");
            
            pst.setString(1, updatedCourses.getName());
            pst.setString(2, updatedCourses.getId());
            
            int rowsAffected = pst.executeUpdate();
            loggerApp.doLogInfo("update_courses", "update()",String.valueOf(rowsAffected));
        
    }
    
}
