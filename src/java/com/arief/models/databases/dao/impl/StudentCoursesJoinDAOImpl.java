/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.databases.dao.impl;

import com.arief.models.databases.dao.StudentCoursesJoinDAO;
import com.arief.models.entity.StudentCoursesJoin;
import com.arief.utils.MyLoggerApp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arief
 */
public class StudentCoursesJoinDAOImpl implements StudentCoursesJoinDAO{

    private final  Connection con;
    private final MyLoggerApp LOGGER_APP;
    
    public StudentCoursesJoinDAOImpl(Connection con) {
        this.con = con;
        LOGGER_APP = new MyLoggerApp(this.getClass().getName());
    }
    
    
    
    @Override
    public List<StudentCoursesJoin> findAllOnlyCoursesNameAndStudentName() throws SQLException {
        List<StudentCoursesJoin> data = new ArrayList<>();
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select c.name as courses_name , s.name as student_name from courses c " +
            " inner join student_course sc " +
            " on c.id = sc.courses_id " +
            " inner join student s " +
            " on s.id = sc.student_id"
        );
        
        while (rs.next()) {            
            data.add(new StudentCoursesJoin(rs.getString("courses_name"), rs.getString("student_name")));
        }
        
        LOGGER_APP.doLogInfo("find_all_courses_name_and_student_name", "findAllOnlyCoursesNameAndStudentName", "fetching data .....");
        return data;
    }
    
}
