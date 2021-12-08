package com.foxminded.task7_sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.foxminded.task7_sql.db.Queries;
import com.foxminded.task7_sql.entity.Course;

public class CourseDaoImpl implements CourseDao {

    private DAOFactory daoFactory = DAOFactory.getInstance();

    private Connection connection;

    public CourseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public CourseDaoImpl() {

    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public List<Course> getAll() throws DAOException {
        List<Course> resultList = new ArrayList<Course>();
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("getAllCourse_query"))) {
            while (resultSet.next()) {
                Course course = new Course(resultSet.getInt("course_id"), resultSet.getString("course_name"),
                        resultSet.getString("course_description"));
                resultList.add(course);
            }

        } catch (SQLException e) {
            throw new DAOException("Error get All Course", e);
        }
        return resultList;
    }

    @Override
    public void save(Course course) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("saveCourse_query"),
                        Statement.RETURN_GENERATED_KEYS)) {
            dtatement.setLong(1, course.getCourseId());
            dtatement.setString(2, course.getCourseName());
            dtatement.setString(3, course.getCourseDescription());
            dtatement.execute();

        } catch (SQLException e) {
            throw new DAOException("Error save Course", e);
        }
    }

    @Override
    public void update(Course course, String[] params) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("updateCourse_query"),
                        params)) {
            dtatement.setString(1, course.getCourseName());
            dtatement.setString(2, course.getCourseDescription());
            dtatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error update course", e);
        }
    }

    @Override
    public void delete(Course course) throws DAOException {
        try (Connection connection = daoFactory.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Queries.getQuery("deleteCourse_query") + course.getCourseId());
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            throw new DAOException("Error delete course", e);
        }
    }

    public void findAllStudentCourses(int studentId) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("findAllStudentCourses_query1")
                        + studentId + Queries.getQuery("findAllStudentCourses_query2"))) {
            while (resultSet.next()) {
                int id = resultSet.getInt("course_id");
                String name = resultSet.getString("course_name");
                String description = resultSet.getString("course_description");
                StringBuilder courseLine = new StringBuilder();
                courseLine.append(id + " ");
                courseLine.append(name + " ");
                courseLine.append(description + "\n");
                System.out.println(courseLine.toString());
            }

        } catch (SQLException e) {
            throw new DAOException("Error find All Student Courses", e);
        }
    }

    @Override
    public void addCourse(Course course) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("addCourse_query"),
                        Statement.RETURN_GENERATED_KEYS)) {
            dtatement.setLong(1, course.getCourseId());
            dtatement.setString(2, course.getCourseName());
            dtatement.setString(3, course.getCourseDescription());
            dtatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error add Course", e);
        }

    }

    public void removeStudentFromCourse(int courseStudentId, int studentCourseId) throws DAOException {
        try (Connection connection = daoFactory.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Queries.getQuery("removeStudentFromCourse_query1") + courseStudentId
                    + Queries.getQuery("removeStudentFromCourse_query2") + studentCourseId);
            System.out.println("Student is removed from the course " + studentCourseId);
        } catch (SQLException e) {
            throw new DAOException("Error remove Student From Course", e);
        }
    }

}
