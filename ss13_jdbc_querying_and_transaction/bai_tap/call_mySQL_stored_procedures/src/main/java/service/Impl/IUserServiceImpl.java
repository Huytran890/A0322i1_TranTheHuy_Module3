package service.Impl;

import models.User;
import repository.IUserRepository;
import repository.Impl.IUserRepositoryImpl;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class IUserServiceImpl implements IUserService {
    IUserRepository userRepository = new IUserRepositoryImpl();

    @Override
    public void insertUser(User user) throws SQLException {
        this.userRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return this.userRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.userRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userRepository.updateUser(user);
    }

    @Override
    public List<User> searchUser(String country) {
        return this.userRepository.searchUser(country);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        this.userRepository.insertUserStore(user);
    }
}
