package repository.Impl;

import Utils.ConnectionUtils;
import Utils.Constants;
import models.User;
import repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void insertUser(User user) throws Exception {
        if (selectUser(user.getId()) != null) {
            throw new Exception("Duplicate Key");
        }
        try (
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(Constants.INSERT_INTO_USERS);){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
//            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            // excuteQuery de
        }
    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        try (Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.FIND_USERS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id,name,email,country);
            }
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.SELECT_ALL_FROM_USERS);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        }
        return userList;
    }

    @Override
    public List<User> searchCountry(String country) throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.SEARCH_USERS_BY_COUNTRY);) {
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                userList.add(new User(id,name,email,country));
            }
        }
        return userList;
    }

    @Override
    public List<User> sortByName() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.SORT_USERS_BY_NAME);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.DELETE_USERS);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        boolean rowUpdated;
        try (Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.UPDATE_USERS);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4,user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            System.out.println(rowUpdated);
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
