import java.sql.Connection;


import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


import com.foxminded.task7_sql.dao.DAOException;
import com.foxminded.task7_sql.dao.DAOFactory;
import com.foxminded.task7_sql.dao.GroupDaoImpl;
import com.foxminded.task7_sql.db.ReaderSql;
import com.foxminded.task7_sql.db.SqlExecutor;
import com.foxminded.task7_sql.entity.Student;
import com.foxminded.task7_sql.interactive.Menu;
import com.foxminded.task7_sql.service.GenerationTestData;
import com.foxminded.task7_sql.service.StudentService;

import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) throws SQLException, DAOException {
        String DATABASE_DRIVER = "org.postgresql.Driver";
        String DATABASE_URL = "jdbc:postgresql://localhost:5432/mydbschooll";
        String USERNAME = "myuserschool";
        String PASSWORD = "1234";
        DAOFactory daoFactory=DAOFactory.getInstance();
        daoFactory.setInfConnection(DATABASE_DRIVER, DATABASE_URL, USERNAME, PASSWORD);
        GenerationTestData testData = new GenerationTestData();
        ReaderSql reader = new ReaderSql();
        SqlExecutor sqlExecutor = new SqlExecutor();
        Menu menu = new Menu();
        sqlExecutor.runScript(reader.read());
        testData.addTestDataInDB();
         menu.startProgram();
        
    }

}
