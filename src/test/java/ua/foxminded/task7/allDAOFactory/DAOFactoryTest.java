package ua.foxminded.task7.allDAOFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.foxminded.task7_sql.dao.DAOFactory;

class DAOFactoryTest {
    
    private final String  DATABASE_DRIVER = "org.h2.Driver";
    private final String  DATABASE_URL = "jdbc:h2:tcp://localhost/~/test";
    private final String  USERNAME ="sa";
    private final String  PASSWORD = "";

    @Test
    void testConnection() {
        DAOFactory daoFactory=DAOFactory.getInstance();
        daoFactory.setInfConnection(DATABASE_DRIVER, DATABASE_URL, USERNAME, PASSWORD);
        Connection connection=daoFactory.getConnection();
        assertNotNull(connection);
    }
}
