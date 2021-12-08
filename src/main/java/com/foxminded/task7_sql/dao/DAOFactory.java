package com.foxminded.task7_sql.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.foxminded.task7_sql.entity.Student;

public class DAOFactory {

    private static DAOFactory instance;

    private static Connection connection;

    public static String DATABASE_DRIVER;
    public static String DATABASE_URL;
    public static String USERNAME;
    public static String PASSWORD;

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public DAOFactory() {
        super();
    }

    public void setInfConnection(String dATABASE_DRIVER, String dATABASE_URL, String uSERNAME, String pASSWORD) {
        this.DATABASE_DRIVER = dATABASE_DRIVER;
        this.DATABASE_URL = dATABASE_URL;
        this.USERNAME = uSERNAME;
        this.PASSWORD = pASSWORD;
    }

    public static Connection getConnection() {
        try {
            Class.forName(DATABASE_DRIVER);
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
