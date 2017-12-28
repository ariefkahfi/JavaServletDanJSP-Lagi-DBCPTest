/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.databases.dao.impl;

import com.arief.models.databases.dao.StudentDAO;
import com.arief.models.entity.Student;
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
public class StudentDAOImpl implements StudentDAO{

    private final Connection con;
    private final MyLoggerApp loggerApp;
    
    public StudentDAOImpl(Connection con) {
        this.con = con;
        loggerApp = new MyLoggerApp(this.getClass().getName());
        loggerApp.doLogInfo("construct StudentDAOImpl", "StudentDAOImpl()", "called ....");
    }
    
    
    
    @Override
    public void save(Student s) throws SQLException{
        PreparedStatement pst = con.prepareStatement("insert into student (name,gender) values (?,?)");
        
        pst.setString(1, s.getName());
        pst.setString(2, s.getGender());
        
        int rowsAffected = pst.executeUpdate();
        
        loggerApp.doLogInfo("save_student", "save(Student s)", "Rows affected : " + String.valueOf(rowsAffected));
        
    }

    @Override
    public List<Student> getStudentList() throws SQLException{
       List<Student> data = new ArrayList<>();
       
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from student");
       
       while (rs.next()) {            
            data.add(
                    new Student(
                            rs.getInt("id"), 
                            rs.getString("name"), 
                            rs.getString("gender")
                    )
            );
       }
       loggerApp.doLogInfo("get_student_list", "getStudentList()", "fetching data from student table....");
       return data;
    }

    @Override
    public void delete(int studentId) throws SQLException{
        // not implemented yet ....
    }

    @Override
    public void update(Student updatedStudent) throws SQLException{
        PreparedStatement pst = con.prepareStatement("update student s set s.name = ? , s.gender = ? where s.id = ?");
        
        pst.setString(1, updatedStudent.getName());
        pst.setString(2, updatedStudent.getGender());
        pst.setInt(3, updatedStudent.getId());
        
        int rowsAffected = pst.executeUpdate();
        
        loggerApp.doLogInfo("update_student", "update()", "Rows affected : " + rowsAffected);
        
    }
    
}
