package service.impl;

import models.User;
import repository.Impl.UserRepositoryImpl;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void insertUser(User user) throws Exception {
        userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {
        return userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() throws SQLException, ClassNotFoundException {
        return userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws Exception {
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> searchCountry(String country) throws SQLException, ClassNotFoundException {
        return userRepository.searchCountry(country);
    }

    @Override
    public List<User> sortByName() throws SQLException, ClassNotFoundException {
        return userRepository.sortByName();
    }
}
