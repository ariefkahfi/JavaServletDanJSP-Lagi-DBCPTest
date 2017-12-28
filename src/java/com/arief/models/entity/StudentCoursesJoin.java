/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.entity;

/**
 *
 * @author arief
 */
public class StudentCoursesJoin {
    private String coursesName;
    private String studentName;

    public StudentCoursesJoin() {
    }

    public StudentCoursesJoin(String coursesName, String studentName) {
        this.coursesName = coursesName;
        this.studentName = studentName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCoursesName() {
        return coursesName;
    }

    public String getStudentName() {
        return studentName;
    }
    
    
}
