package repository.Impl;

import models.Account;
import models.Student;
import repository.StudentRepository;
import utils.AccountConstants;
import utils.ConnectionUtils;
import utils.StudentConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void addNewStudent(Student student) {
        System.out.println(StudentConstants.INSERT_STUDENTS);
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(StudentConstants.INSERT_STUDENTS);) {
                statement.setString(1, student.getName());
                statement.setInt(2, student.getGender());
                statement.setDate(3, new java.sql.Date(student.getDob().getTime()));
                System.out.println(statement);
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> showListStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(StudentConstants.SELECT_ALL_STUDENTS);) {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_student = resultSet.getInt(1);
                    String name_student = resultSet.getString(2);
                    int gender_student = resultSet.getInt(3);
                    Date dob_student = resultSet.getDate(4);

                    studentList.add(new Student(id_student, name_student, gender_student, dob_student));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        boolean rowUpdated;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(StudentConstants.UPDATE_STUDENTS);) {
            System.out.println("Updated Product: " + statement);
            statement.setInt(4, student.getId());
            statement.setString(1, student.getName());
            statement.setInt(2, student.getGender());
            statement.setDate(3, new java.sql.Date(student.getDob().getTime()));

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(StudentConstants.DELETE_STUDENTS);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Student searchStudentByID(int id) {
        Student student = null;
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(StudentConstants.SEARCH_STUDENTS_BY_ID);) {
                statement.setInt(1, id);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String name_student = resultSet.getString(2);
                    int gender_student = resultSet.getInt(3);
                    Date dob = resultSet.getDate(4);

                    student = new Student(id, name_student, gender_student, dob);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Account login(String user, String password) {
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(AccountConstants.LOGIN_TO_WEBSITE);) {
                statement.setString(1, user);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return new Account(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> searchStudentByName(String name) {
        List<Student> studentList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(StudentConstants.SEARCH_STUDENTS_BY_NAME);) {
                statement.setString(1, name);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    int id_student = resultSet.getInt(1);
//                    String name_student = resultSet.getString(2);
                    int gender_student = resultSet.getInt(3);
                    Date dob_student = resultSet.getDate(4);

                    studentList.add(new Student(id_student, name, gender_student, dob_student));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void printSQLException(SQLException ex) {
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
