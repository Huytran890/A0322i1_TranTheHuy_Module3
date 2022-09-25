package repository;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    void insertUser(User user) throws Exception;

    User selectUser(int id) throws SQLException, ClassNotFoundException;

    List<User> selectAllUsers() throws SQLException, ClassNotFoundException;

    List<User> searchCountry(String country) throws SQLException, ClassNotFoundException;

    List<User> sortByName() throws SQLException, ClassNotFoundException;

    boolean deleteUser(int id) throws SQLException, ClassNotFoundException;

    boolean updateUser(User user) throws Exception;
}
