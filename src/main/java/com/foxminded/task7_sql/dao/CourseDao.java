package com.foxminded.task7_sql.dao;

import java.util.List;

import com.foxminded.task7_sql.entity.Course;


public interface CourseDao extends GenericDao<Course>{
    
    List<Course> getAll() throws DAOException;
    void addCourse (Course cours) throws DAOException;
    
        
}
