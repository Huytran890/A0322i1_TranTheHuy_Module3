package repository.employee_repository;

import models.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    void insertEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    List<Employee> selectAllEmployee() throws SQLException, ClassNotFoundException;

    Employee searchEmployeeByID(int id) throws SQLException, ClassNotFoundException;

    void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    void deleteEmployee(int id) throws SQLException, ClassNotFoundException;

    List<Employee> listNameEmployee(String name) throws SQLException, ClassNotFoundException;
}
