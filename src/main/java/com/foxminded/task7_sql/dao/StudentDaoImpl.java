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
import com.foxminded.task7_sql.entity.Student;

public class StudentDaoImpl implements StudentDao {

    private DAOFactory daoFactory = DAOFactory.getInstance();

    private Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public StudentDaoImpl() {

    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void save(Student student) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("save_query"), Statement.RETURN_GENERATED_KEYS)) {
            dtatement.setLong(1, student.getStudent_id());
            dtatement.setLong(2, student.getGroup_id());
            dtatement.setString(3, student.getFirst_name());
            dtatement.setString(4, student.getLast_name());
            dtatement.execute();

        } catch (SQLException e) {
            throw new DAOException("erro save Student ",e);
        }

    }


    @Override
    public void update(Student student, String[] params) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("update_query"), params)) {
            dtatement.setLong(1, student.getGroup_id());
            dtatement.setString(2, student.getFirst_name());
            dtatement.setString(3, student.getLast_name());
            dtatement.execute();

        } catch (SQLException e) {
            throw new DAOException("erro update Student ",e);
        }
    }

    @Override
    public void delete(Student student) throws DAOException {
        try (Connection connection = daoFactory.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Queries.getQuery("save_query")+student.getStudent_id());
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            throw new DAOException("erro delete Student ",e);
        }
    }

    @Override
    public List<Student> getAll() throws DAOException {
        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student();
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("getAll_query"))) {
            while (resultSet.next()) {
                student.setStudent_id(resultSet.getInt("student_id"));
                student.setGroup_id(resultSet.getInt("group_id"));
                student.setFirst_name(resultSet.getString("first_name"));
                student.setLast_name(resultSet.getString("last_name"));
                studentList.add(student);
            }

        } catch (SQLException e) {
            throw new DAOException("erro getAll Student ",e);
        }
        return studentList;

    }

    @Override
    public void removeStudentByGroupId(int id) throws DAOException {
        try (Connection connection = daoFactory.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Queries.getQuery("removeStudentByGroupId_query")+id);
            
        } catch (SQLException e) {
            throw new DAOException("erro  remove Student By Group Id",e);
        }
    }
    @Override
    public void addStudent(Student student) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("save_query"), Statement.RETURN_GENERATED_KEYS)) {

            dtatement.setLong(1, student.getStudent_id());
            dtatement.setLong(2, student.getGroup_id());
            dtatement.setString(3, student.getFirst_name());
            dtatement.setString(4, student.getLast_name());
            dtatement.execute();

        } catch (SQLException e) {
            throw new DAOException("erro add Student",e);
        }

    }
    @Override
    public void deleteStudentByStudentId(int id) throws DAOException {
        try (Connection connection = daoFactory.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Queries.getQuery("deleteStudentByStudentId_query")+ id);
        } catch (SQLException e) {
            throw new DAOException("erro delete Student By Student Id",e);
        }

    }

    @Override
    public void addCourse(int sId, int cId) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("addSCourse_query"));) {
            dtatement.setInt(1, sId);
            dtatement.setInt(2, cId);
            dtatement.addBatch();
            dtatement.executeBatch();
        } catch (SQLException e) {
            throw new DAOException("erro addCourse",e);
        }

    }
    
    @Override
    public  List<String> findAllStudentsCourseGivenName(String courseName) throws DAOException {
        List<String> resultList = new ArrayList<String>();
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("findStCoGivenName_query1")+courseName+Queries.getQuery("findStCoGivenName_query2"))) {
            while (resultSet.next()) {
                String cName = resultSet.getString("course_name");
                String fName = resultSet.getString("first_name");
                String sName = resultSet.getString("last_name");
                String result = cName + " " + sName + " " + fName;
                resultList.add(result);
            }

        } catch (SQLException e) {
            throw new DAOException("Cannot find All Students Course Given Name",e);
        }
        return resultList;

    }

}
