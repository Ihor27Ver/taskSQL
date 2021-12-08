package com.foxminded.task7_sql.interactive;

import java.util.List;

import com.foxminded.task7_sql.entity.Course;
import com.foxminded.task7_sql.entity.Student;

public class Formatter {

    private String EMPTY = " ";
    private String PARAGRAPH = "\n";

    public void studentDisplay(List<Student> sl) {
        StringBuilder studentLine = new StringBuilder();
        for (int i = 0; i < sl.size(); i++) {
            Student student = sl.get(i);
            studentLine.append((i + 1) + EMPTY);
            studentLine.append(student.getFirst_name() + EMPTY);
            studentLine.append(student.getLast_name() + EMPTY);
            studentLine.append(PARAGRAPH);
        }
        System.out.println(studentLine.toString());

    }

    public void coursesDisplay(List<Course> list) {
        StringBuilder courseLine = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Course course = list.get(i);
            courseLine.append(course.getCourseId() + EMPTY);
            courseLine.append(course.getCourseName() + EMPTY);
            courseLine.append(course.getCourseDescription() + EMPTY);
            courseLine.append(PARAGRAPH);
        }
        System.out.println(courseLine.toString());

    }

}
