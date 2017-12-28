package com.arief.models.databases.dao;

import com.arief.models.entity.Courses;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author arief
 */
public interface CoursesDAO {
    public void save(Courses c) throws SQLException;
    public List<Courses> getCourses() throws SQLException;
    public void delete(String coursesId) throws SQLException;
    public void update(Courses updatedCourses) throws SQLException;
}
