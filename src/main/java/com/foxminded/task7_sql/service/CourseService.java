package com.foxminded.task7_sql.service;


import java.util.List;
import java.util.Scanner;

import com.foxminded.task7_sql.dao.CourseDaoImpl;
import com.foxminded.task7_sql.dao.DAOException;
import com.foxminded.task7_sql.entity.Course;


public class CourseService {
    
   
    
    public void create(Course course) throws DAOException {
        CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
        courseDaoImpl.addCourse(course);
    }
    
    public void removeStudentFromCourse() throws DAOException {
        CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
        Scanner  studentId = new Scanner(System.in);
        System.out.println("Enter ID student"); 
        int courseStudentId= studentId.nextInt();
        courseDaoImpl.findAllStudentCourses(courseStudentId);
      
        Scanner  courseId = new Scanner(System.in);
        System.out.println("Enter ID course");
        int studentCourseId= courseId.nextInt();
        
        courseDaoImpl.removeStudentFromCourse(courseStudentId,studentCourseId);  
    }
    public List<Course> coursesGetAll() throws DAOException {
        CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
        List<Course> courseList=courseDaoImpl.getAll();
    return courseList;
    }
}
