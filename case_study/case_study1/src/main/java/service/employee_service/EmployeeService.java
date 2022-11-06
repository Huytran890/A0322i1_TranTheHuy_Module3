package service.employee_service;

import models.employee.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Map<String, String> insertEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    Employee searchEmployeeByID(int id) throws SQLException, ClassNotFoundException;

    List<Employee> selectAllEmployee() throws SQLException, ClassNotFoundException;

    void updateEmployee(Employee customer) throws SQLException, ClassNotFoundException;

    void deleteEmployee(int id) throws SQLException, ClassNotFoundException;

    List<Employee> listNameEmployee(String name) throws SQLException, ClassNotFoundException;
}
