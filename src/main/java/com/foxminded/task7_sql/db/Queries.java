package com.foxminded.task7_sql.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Queries {
    private static final String propFileName = "query.properties";
    private static Properties props;

    public static Properties getQueries() throws SQLException {
        InputStream is = 
            Queries.class.getResourceAsStream("/" + propFileName);
        if (is == null){
            throw new SQLException("Unable to load property file: " + propFileName);
        }
        
        if(props == null){
            props = new Properties();
            try {
                props.load(is);
            } catch (IOException e) {
                throw new SQLException("Unable to load property file: " + propFileName + "\n" + e.getMessage());
            }           
        }
        return props;
    }

    public static String getQuery(String query) throws SQLException{
        return getQueries().getProperty(query);
    }

}

