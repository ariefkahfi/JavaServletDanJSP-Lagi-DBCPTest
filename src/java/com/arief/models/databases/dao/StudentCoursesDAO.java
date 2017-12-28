package com.arief.models.databases.dao;

import com.arief.models.entity.StudentCourses;

import java.sql.SQLException;


/**
 *
 * @author arief
 */
public interface StudentCoursesDAO {
    public boolean saveRelation(StudentCourses sc) throws SQLException;
    public void deleteRelation(StudentCourses sc) throws SQLException;
    public boolean isExists(int studentId , String courseId)throws SQLException;
}
