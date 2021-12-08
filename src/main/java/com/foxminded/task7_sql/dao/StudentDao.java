package com.foxminded.task7_sql.dao;

import java.util.List;
import java.util.Optional;

import com.foxminded.task7_sql.entity.Student;

public interface StudentDao extends GenericDao<Student>{
    List<Student> getAll() throws DAOException;
    void removeStudentByGroupId(int id) throws DAOException;
    void addStudent (Student t) throws DAOException;
    void addCourse (int student_id,int  course_id) throws DAOException;
    List<String> findAllStudentsCourseGivenName(String courseName) throws DAOException;
    void deleteStudentByStudentId(int id) throws DAOException;
    
}
