/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.test;

import com.arief.models.databases.ConnectionFactory;
import com.arief.models.databases.dao.StudentCoursesDAO;
import com.arief.models.databases.dao.impl.StudentCoursesDAOImpl;
import com.arief.models.entity.Student;
import com.arief.models.entity.StudentCourses;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;

/**
 *
 * @author arief
 */
@RunWith(JUnit4.class)
public class TestApp {
    
    
    @Test
    public void testSaveRelation() throws SQLException{
        StudentCourses sc = new StudentCourses(1, "C001");
        
        
        StudentCoursesDAO scDAO = new StudentCoursesDAOImpl(new ConnectionFactory().getConnectionInstance());
        
        scDAO.saveRelation(sc);
        
    }
    
    //@Test
    public void writeJSONArray(){
        Gson g = new Gson();
        
        
        ArrayList<Student> data = new ArrayList<>();
        
        data.add(new Student(1, "Arief", "Male"));
        data.add(new Student(2, "Putro", "Male"));
        data.add(new Student(3, "Zack", "Male"));
        
        
        String jsonList = g.toJson(data);
        
        Assert.assertNotNull(jsonList);
        
        
        System.out.println(jsonList);
        
    }
}
