package com.foxminded.task7_sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.foxminded.task7_sql.db.Queries;
import com.foxminded.task7_sql.entity.Group;
import com.foxminded.task7_sql.entity.Student;

public class GroupDaoImpl implements GroupDao {

    private DAOFactory daoFactory = DAOFactory.getInstance();

    public GroupDaoImpl() {

    }

    @Override
    public void save(Group group) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("saveGroup_query"), Statement.RETURN_GENERATED_KEYS)) {
            dtatement.setLong(1, group.getGroup_id());
            dtatement.setString(2, group.getGroup_name());
            dtatement.execute();

        } catch (SQLException e) {
            throw new DAOException("Error save Group",e);
        }

    }
    @Override
    public void update(Group group, String[] params) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("updateGroup_query"), params)) {
            dtatement.setString(1, group.getGroup_name());
            dtatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error update Group ",e);
        }
    }

    @Override
    public void delete(Group group) throws DAOException {
        try (Connection connection = daoFactory.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(Queries.getQuery("deleteGroup_query")+group.getGroup_id());
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            throw new DAOException("Error delete Group ",e);
        }
    }
    @Override
    public List<Group> getAll() throws DAOException {
        String sql = " select * from groups";
        List<Group> groupList = new ArrayList<Group>();
        Group group = new Group();
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("getAllGroup_query"))) {

            while (resultSet.next()) {
                group.setGroup_id(resultSet.getInt("group_id"));
                group.setGroup_name(resultSet.getString("group_name"));
                groupList.add(group);
            }

        } catch (SQLException e) {
            throw new DAOException("Error getAll Group ",e);
        }
        return groupList;

    }

    @Override
    public void addGroup(Group group) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                PreparedStatement dtatement = connection.prepareStatement(Queries.getQuery("saveGroup_query"), Statement.RETURN_GENERATED_KEYS)) {
            dtatement.setLong(1, group.getGroup_id());
            dtatement.setString(2, group.getGroup_name());
            dtatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error add Group",e);
        }

    }

    public List<String> findAllGroupsLessOrEqualNumber(int n) throws DAOException {
        List<String> resultList = new ArrayList<String>();
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("findAllGroupsLessOrEqualNumber_query")+n)) {
            while (resultSet.next()) {
                String name = resultSet.getString("group_name");
                resultList.add(name);
            }
        } catch (SQLException e) {
            throw new DAOException("Error find All Groups Less Or Equal Number",e);

        }
        return resultList;

    }

    @Override
    public void findGroupById(int id) throws DAOException {
        try (Connection connection = daoFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(Queries.getQuery("findGroupById_query")+id)) {
            while (resultSet.next()) {
                String name = resultSet.getString("group_name");
            }

        } catch (SQLException e) {
            throw new DAOException("Error find Group By Id",e);
        }
    }

}
