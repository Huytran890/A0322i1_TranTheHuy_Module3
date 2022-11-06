package repository;

import models.Account;
import models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {
    void addNewStudent(Student student);

    List<Student> showListStudent();

    boolean update(Student student) throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws ClassNotFoundException, SQLException;

    Student searchStudentByID(int id);

    Account login(String user, String password);

    List<Student> searchStudentByName(String name);
}
