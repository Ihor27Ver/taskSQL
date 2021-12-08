package com.foxminded.task7_sql.dao;

import java.util.List;

import com.foxminded.task7_sql.entity.Group;

public interface GroupDao extends GenericDao<Group> {
    List<Group> getAll() throws DAOException;
    void findGroupById(int id) throws DAOException;
    void addGroup (Group group) throws DAOException;
}
