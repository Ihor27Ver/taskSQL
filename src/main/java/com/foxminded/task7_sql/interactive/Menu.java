package com.foxminded.task7_sql.interactive;

import java.util.Scanner;

import com.foxminded.task7_sql.dao.DAOException;
import com.foxminded.task7_sql.service.CourseService;
import com.foxminded.task7_sql.service.GruopService;
import com.foxminded.task7_sql.service.StudentService;

public class Menu {

    private String textMenu = "Select the desired option and enter the letter: \n" + "\n"
            + "    a. Find all groups with less or equals student count \n" + "\n"
            + "    b. Find all students related to course with given name \n" + "\n"
            + "    c. Add new student \n"+ "\n" 
            + "    d. Delete student by STUDENT_ID \n" + "\n"
            + "    e. Add a student to the course (from a list) \n" + "\n"
            + "    f. Remove the student from one of his or her courses \n";

    public void startProgram() throws DAOException {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        GruopService gruopService = new GruopService();

        System.out.println(textMenu);
        Scanner in = new Scanner(System.in);
        String user—hoice = in.nextLine();

        String first—hoice = "a";
        String secend—hoice = "b";
        String three—hoice = "c";
        String fourth—hoice = "d";
        String five—hoice = "e";
        String six—hoice = "f";

        if (user—hoice.equals(first—hoice)) {
            System.out.println("Enter the number of students: ");
            Scanner in1 = new Scanner(System.in);
            int numberStudents = in1.nextInt();
            gruopService.findAllGroupsLessOrEqualNumber(numberStudents);
        }
        if (user—hoice.equals(secend—hoice)) {
            System.out.println("Enter the name of course: ");
            Scanner in1 = new Scanner(System.in);
            String nameCourse = in1.nextLine();
            studentService.findAllStudentsCourseGivenName(nameCourse);
        }
        if (user—hoice.equals(three—hoice)) {
            studentService.createStudent();
        }
        if (user—hoice.equals(fourth—hoice)) {
            studentService.deletedStudent();
        }

        if (user—hoice.equals(five—hoice)) {
            studentService.addStudentToCourseFromList();
        }
        if (user—hoice.equals(six—hoice)) {
            courseService.removeStudentFromCourse();
        }
    }

}
