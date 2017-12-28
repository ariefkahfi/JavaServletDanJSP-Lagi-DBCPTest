/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.models.databases.dao;

import com.arief.models.entity.StudentCoursesJoin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author arief
 */
public interface StudentCoursesJoinDAO {
    public List<StudentCoursesJoin> findAllOnlyCoursesNameAndStudentName()throws SQLException;
}
