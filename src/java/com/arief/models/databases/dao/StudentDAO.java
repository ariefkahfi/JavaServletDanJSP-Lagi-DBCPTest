package com.arief.models.databases.dao;

import com.arief.models.entity.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author arief
 */
public interface StudentDAO {
    public void save(Student s) throws SQLException;
    public List<Student> getStudentList() throws SQLException;
    public void delete(int studentId) throws SQLException;
    public void update(Student updatedStudent) throws SQLException;
}
