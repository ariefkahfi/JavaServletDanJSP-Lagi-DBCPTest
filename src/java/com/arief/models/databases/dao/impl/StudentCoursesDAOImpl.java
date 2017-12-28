/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.databases.dao.impl;


import com.arief.models.databases.dao.StudentCoursesDAO;
import com.arief.models.entity.StudentCourses;
import com.arief.utils.MyLoggerApp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arief
 */
public class StudentCoursesDAOImpl implements StudentCoursesDAO{

    private final Connection con;
    private final MyLoggerApp LOGGER_APP;
    
    public StudentCoursesDAOImpl(Connection con) {
        this.con = con;
        LOGGER_APP = new MyLoggerApp(this.getClass().getName());
    }

    @Override
    public boolean isExists(int studentId , String courseId) throws SQLException {
        
        PreparedStatement pst = con.prepareStatement("select * from student_course "
                + " where student_id = ? and courses_id = ? ");
        
        pst.setInt(1, studentId);
        pst.setString(2, courseId);
        
        
        ResultSet rs = pst.executeQuery();        
        return rs.next();
    }
    
    
    
    @Override
    public boolean saveRelation(StudentCourses sc) throws SQLException{
        if(!isExists(sc.getStudentId(), sc.getCoursesId())){
            PreparedStatement pst = con.prepareStatement("insert into student_course values (?,?)");
            pst.setInt(1, sc.getStudentId());
            pst.setString(2, sc.getCoursesId());
            
            
            int rows = pst.executeUpdate();
            
            LOGGER_APP.doLogInfo("save_relation_many_to_many", "saveRelation", "Rows affected  : " + rows);
            
            return true;
            
        }else{
            LOGGER_APP.doLogInfo("save_relation_many_to_many", "saveRelation", "save data canceled");
            return false;
        }
        
    }

    @Override
    public void deleteRelation(StudentCourses sc) throws SQLException{
        PreparedStatement pst = con.prepareStatement("delete from student_course where "
                + " student_id = ? and courses_id = ? ");
        pst.setInt(1, sc.getStudentId());
        pst.setString(2, sc.getCoursesId());
        
        int rowsAffected = pst.executeUpdate();
        
        LOGGER_APP.doLogInfo("delete_relation", "deleteRelation", "rows affected : " + rowsAffected);
        
    }
}
