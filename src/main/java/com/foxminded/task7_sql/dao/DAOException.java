package com.foxminded.task7_sql.dao;

import java.sql.SQLException;

public class DAOException extends  Exception {
    
    

    public DAOException() {
        super();
    } 
    
    public DAOException(String error) {
        super(error);
    }

    public DAOException(String error, Throwable cause) {
        super(error,cause);
        
    }
    

}