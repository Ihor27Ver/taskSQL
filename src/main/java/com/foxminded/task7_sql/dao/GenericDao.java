package com.foxminded.task7_sql.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    
    List<T> getAll() throws DAOException;
    
    void save(T t) throws DAOException;
    
    void update(T t, String[] params) throws DAOException;
    
    void delete(T t) throws DAOException;

}
