package com.foxminded.task7_sql.service;



import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

import com.foxminded.task7_sql.dao.DAOException;
import com.foxminded.task7_sql.dao.StudentDaoImpl;
import com.foxminded.task7_sql.entity.Course;
import com.foxminded.task7_sql.entity.Group;
import com.foxminded.task7_sql.entity.Student;

public class GenerationTestData {

    public void addTestDataInDB() throws DAOException  {
            createGoup();
            createCourse();
            createStudent();
            createStudentCourseRelation();
    }

    public List<String> createGoup() throws DAOException {
        Group group = new Group();
        GruopService groupService = new GruopService();
        List<String> groupLines = new LinkedList<>();
        int min = 10;
        int max = 100;
        int diff = max - min;
        int i = 0;
        while (i < 10) {
            Random random = new Random();
            int n = random.nextInt(diff + 1);
            n += min;
            String string = RandomStringUtils.randomAlphabetic(2) + n;
            groupLines.add(string);
            group.setGroup_id(i + 1);
            group.setGroup_name(string);
            groupService.create(group);
            i++;
        }
        return groupLines;
    }

    public List<String> createCourse() throws DAOException {
        Course ñourse = new Course();
        CourseService ñourseService = new CourseService();
        List<String> ñourseLines = new LinkedList() {
            {
                add("math");
                add("biology");
                add("business");
                add("humanities");
                add("data science");
                add("personal development");
                add("programming");
                add("health & medicine");
                add("engineering");
                add("social sciences");
            }
        };
        for (int i = 0; i < 10; i++) {
            ñourse.setCourseId(i + 1);
            ñourse.setCourseName(ñourseLines.get(i));
            ñourse.setCourseDescription(ñourseLines.get(i) + " cool");
            ñourseService.create(ñourse);
        }
        return ñourseLines;
    }

    public void createStudent( ) throws DAOException {
        Student student = new Student();
        StudentService studentService = new StudentService();
        List<String> studentFirstName = new LinkedList() {
            {
                add("Prisha");
                add("Anvika");
                add("Aarvi");
                add("Divisha");
                add("Rutvi");
                add("Aadvika");
                add("Anaya");
                add("Trishika");
                add("Kayra");
                add("Aashvi");
                add("Kiyansh");
                add("Aayansh");
                add("Nirved");
                add("Avyukt");
                add("Rihaan");
                add("Aarav");
                add("Ivan");
                add("Sasha");
                add("Vivaan");
                add("Ihor");
            }
        };
        List<String> studentLastName = new LinkedList() {
            {
                add("Mayo");
                add("Abbott");
                add("Allen");
                add("Jackson");
                add("Dunn");
                add("Dotson");
                add("Castillo");
                add("Kane");
                add("Richmond");
                add("Roberson");
                add("Sherman");
                add("Merritt");
                add("Andrews");
                add("Middleton");
                add("Frank");
                add("Clements");
                add("Holman");
                add("Vinson");
                add("Hunt");
                add("Richardson");
            }
        };
        for (int i = 0; i < 200; i++) {
            int rndFirstName = new Random().nextInt(studentFirstName.size());
            int rndLastName = new Random().nextInt(studentLastName.size());
            int rndGroup_id = new Random().nextInt(10) + 1;
            student.setGroup_id(rndGroup_id);
            student.setStudent_id(i + 1);
            student.setFirst_name(studentFirstName.get(rndFirstName));
            student.setLast_name(studentLastName.get(rndLastName));
            studentService.create(student);
        }

    }

    private void createStudentCourseRelation( ) throws DAOException {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl(); 
        int rndCourseId = 1;
        for (int i = 1; i < 201; i++) {
            int numberÑourseStudent = new Random().nextInt(3) + 1;
            for (int j = 0; j < numberÑourseStudent; j++) {
                if (numberÑourseStudent == 1) {
                    rndCourseId = new Random().nextInt(10) + 1;
                    studentDaoImpl.addCourse(i, rndCourseId);
                }
                if (numberÑourseStudent == 2) {
                    int nuber = rndCourseId;
                    rndCourseId = new Random().nextInt(10) + 1;
                    if (nuber != rndCourseId) {
                        studentDaoImpl.addCourse(i, rndCourseId);
                    }

                }
                if (numberÑourseStudent == 3) {
                    if (j == 0) {
                        rndCourseId = new Random().nextInt(4) + 1;
                        studentDaoImpl.addCourse(i, rndCourseId);
                    }
                    if (j == 1) {
                        rndCourseId = new Random().nextInt(3) + 5;
                        studentDaoImpl.addCourse(i, rndCourseId);
                    }
                    if (j == 2) {
                        rndCourseId = new Random().nextInt(3) + 8;
                        studentDaoImpl.addCourse(i, rndCourseId);

                    }

                }
            }

        }

    }

    public List<Student> createStudentList() {
        List<Student> students = new LinkedList();
        Student studentFirst = new Student(3, "Ivan", "Ivanov");
        Student studentSecond = new Student(7, "Oleh", "Dum");
        Student studentThird = new Student(1, "Nina", "Casl");
        students.add(studentFirst);
        students.add(studentSecond);
        students.add(studentThird);
        return students;
    }
}
