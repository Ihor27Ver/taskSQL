package ua.foxminded.task7.allStudentDaoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.foxminded.task7_sql.dao.DAOFactory;
import com.foxminded.task7_sql.db.Queries;
import com.foxminded.task7_sql.db.ReaderSql;
import com.foxminded.task7_sql.db.SqlExecutor;
import com.foxminded.task7_sql.entity.Student;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public  class StudentDaoImplTest {
    private List<String> resultList = new ArrayList<String>();
    private final String DATABASE_DRIVER = "org.h2.Driver";
    private final String DATABASE_URL = "jdbc:h2:mem:test;INIT=runscript from '~/sqlScript.sql'";
    private final String USERNAME = "sa";
    private final String PASSWORD = "";
    private final Student STUDENT_FIRST = new Student(1, 9, "Olga", "Novak");
    private final Student STUDENT_SECOND = new Student(2, 3, "Ivan", "Smernov");
    public  Connection CONNECTION;
    
    @BeforeAll
    public void setup() throws SQLException
    {
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.setInfConnection(DATABASE_DRIVER, DATABASE_URL, USERNAME, PASSWORD);
         this.CONNECTION = daoFactory.getConnection();
      
    }
    

    @Test
    void testSave() throws SQLException {
        Student student = new Student();
        PreparedStatement dtatement = CONNECTION.prepareStatement(Queries.getQuery("save_query"));
        dtatement.setLong(1, STUDENT_FIRST.getStudent_id());
        dtatement.setLong(2, STUDENT_FIRST.getGroup_id());
        dtatement.setString(3, STUDENT_FIRST.getFirst_name());
        dtatement.setString(4, STUDENT_FIRST.getLast_name());
         dtatement.execute();
         Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery(Queries.getQuery("getStudentByStudentId_query"));
        while (resultSet.next()) {
            student.setStudent_id(resultSet.getInt("student_id"));
            student.setGroup_id(resultSet.getInt("group_id"));
            student.setFirst_name(resultSet.getString("first_name"));
            student.setLast_name(resultSet.getString("last_name"));
        }
               assertEquals(STUDENT_FIRST,student);

    }

}
