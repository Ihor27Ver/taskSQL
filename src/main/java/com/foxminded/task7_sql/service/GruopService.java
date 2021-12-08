package com.foxminded.task7_sql.service;

import java.util.List;

import com.foxminded.task7_sql.dao.DAOException;
import com.foxminded.task7_sql.dao.GroupDaoImpl;
import com.foxminded.task7_sql.entity.Group;

public class GruopService {

    public void create(Group gruop) throws DAOException {
        GroupDaoImpl groupDaoImpl = new GroupDaoImpl();
        groupDaoImpl.addGroup(gruop);
    }

    public void findAllGroupsLessOrEqualNumber(int n) throws DAOException {
        GroupDaoImpl groupDaoImpl = new GroupDaoImpl();
        List<String> groupList = groupDaoImpl.findAllGroupsLessOrEqualNumber(n);
        for (int i = 0; i < groupList.size(); i++) {
            System.out.println(groupList.get(i));
        }
    }

}
