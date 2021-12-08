package com.foxminded.task7_sql.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.foxminded.task7_sql.dao.CourseDaoImpl;
import com.foxminded.task7_sql.dao.DAOException;
import com.foxminded.task7_sql.dao.DAOFactory;
import com.foxminded.task7_sql.dao.GroupDaoImpl;
import com.foxminded.task7_sql.dao.StudentDao;
import com.foxminded.task7_sql.dao.StudentDaoImpl;
import com.foxminded.task7_sql.entity.Course;
import com.foxminded.task7_sql.entity.Student;
import com.foxminded.task7_sql.interactive.Formatter;

public class StudentService {

   

    public void create(Student student) throws DAOException {
        StudentDaoImpl studentDaoImpl =new StudentDaoImpl();
        studentDaoImpl.addStudent(student);

    }


    public void createStudent() throws DAOException {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        Student student = new Student();

        Scanner groupId = new Scanner(System.in);
        System.out.println("Student Group Id");
        int studentGroupId = groupId.nextInt();

        Scanner firstName = new Scanner(System.in);
        System.out.println("Student First Name");
        String studentFirstName = firstName.nextLine();

        Scanner lastName = new Scanner(System.in);
        System.out.println("Student Last Name");
        String studentLastName = lastName.nextLine();

        student.setStudent_id(201);
        student.setGroup_id(studentGroupId);
        student.setFirst_name(studentFirstName);
        student.setLast_name(studentLastName);
        studentDaoImpl.addStudent(student);
    }

    public void deletedStudent() throws DAOException {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        Scanner studentId = new Scanner(System.in);
        System.out.println("Enter ID student to delete");
        int deletedStudentId = studentId.nextInt();
        studentDaoImpl.deleteStudentByStudentId(deletedStudentId);

    }

    public void addStudentToCourseFromList() throws DAOException {
        Formatter formatter=new Formatter();
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        CourseService course = new CourseService();
        GenerationTestData studentList = new GenerationTestData();

        List<Student> sl = studentList.createStudentList();
        formatter.studentDisplay(sl);

        Scanner studentNumber = new Scanner(System.in);
        System.out.println("Enter the number of the student to add");
        int addStudent = studentNumber.nextInt();
        formatter.coursesDisplay(course.coursesGetAll()); 

        Student student = sl.get(addStudent - 1);
        Student resultAddStudent = new Student(201, student.getGroup_id(), student.getFirst_name(),
                student.getLast_name());
        studentDaoImpl.addStudent(resultAddStudent);

        Scanner courseNumber = new Scanner(System.in);
        System.out.println("Enter the number of the course");
        int addCourse = courseNumber.nextInt();
        studentDaoImpl.addCourse(201, addCourse);
        System.out.println("Student add course");

    }

    

    public void findAllStudentsCourseGivenName(String courseName) throws DAOException {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        List<String> sGivenName = studentDaoImpl.findAllStudentsCourseGivenName(courseName);
        for (int i = 0; i < sGivenName.size(); i++) {
            System.out.println(sGivenName.get(i));
        }
    }

}
