package repository.employee_repository.Impl;

import models.employee.Employee;
import repository.employee_repository.EmployeeRepository;
import utils.ConnectionUtils;
import utils.CustomerConstants;
import utils.EmployeeConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public void insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstants.INSERT_EMPLOYEE);) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdentityCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionID());
            preparedStatement.setInt(9, employee.getDegreeID());
            preparedStatement.setInt(10, employee.getDepartmentID());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Employee> selectAllEmployee() throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstants.SELECT_ALL_EMPLOYEE);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer employeeID = resultSet.getInt("id_employee");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String identityCard = resultSet.getString("identity_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Integer positionID = resultSet.getInt("id_position");
                Integer degreeID = resultSet.getInt("id_standard");
                Integer departmentID = resultSet.getInt("id_part");

                employeeList.add(new Employee(employeeID, name, dateOfBirth, identityCard, salary,
                        phoneNumber, email, address, positionID, degreeID, departmentID));
            }
        }
        return employeeList;
    }

    @Override
    public Employee searchEmployeeByID(int id) throws SQLException, ClassNotFoundException {
        Employee employee = null;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstants.SEARCH_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String identityCard = resultSet.getString("identity_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Integer positionID = resultSet.getInt("id_position");
                Integer degreeID = resultSet.getInt("id_standard");
                Integer departmentID = resultSet.getInt("id_part");

                return employee = new Employee(id, name, dateOfBirth, identityCard, salary,
                        phoneNumber, email, address, positionID, degreeID, departmentID);
            }
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstants.UPDATE_EMPLOYEE);) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdentityCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionID());
            preparedStatement.setInt(9, employee.getDegreeID());
            preparedStatement.setInt(10, employee.getDepartmentID());
            preparedStatement.setInt(11, employee.getEmployeeID());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstants.DELETE_EMPLOYEE);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Employee> listNameEmployee(String name) throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employees = selectAllEmployee();
        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                employeeList.add(employee);
            }
        }
        return employeeList;
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
