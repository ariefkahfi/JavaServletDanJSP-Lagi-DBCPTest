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
public class StudentCourses {
    private int StudentId;
    private String coursesId;

    public StudentCourses() {
    }

    public StudentCourses(int StudentId, String coursesId) {
        this.StudentId = StudentId;
        this.coursesId = coursesId;
    }

    
    
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(String coursesId) {
        this.coursesId = coursesId;
    }
    
    
}
