package com.foxminded.task7_sql.db;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import com.foxminded.task7_sql.dao.DAOFactory;

public class SqlExecutor {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    
    public void runScript(String[] inst) throws SQLException {
       
        try(Connection connection=daoFactory.getConnection();
           Statement statement = connection.createStatement()) {
            for (int i = 0; i < inst.length; i++) {
                if (!inst[i].trim().equals("")) {
                    statement.executeUpdate(inst[i]);
                }
            }
        } 
    }
}

