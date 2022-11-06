package service.employee_service.Impl;

import models.employee.Employee;
import repository.employee_repository.EmployeeRepository;
import repository.employee_repository.Impl.EmployeeRepositoryImpl;
import service.employee_service.EmployeeService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();


    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Map<String, String> employeeMap = new HashMap<>();

        if (employee.getDateOfBirth().equals("")) {
            employeeMap.put("date_of_birth", "Date_Of_Birth can't be empty!");
        } else if (!employee.getDateOfBirth().matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")) {
            employeeMap.put("date_of_birth", "Date_Of_Birth is not valid!");
        }

        if (employee.getIdentityCard().equals("")) {
            employeeMap.put("identity_card", "Identity card can't be empty!");
        } else if (!employee.getIdentityCard().matches("^\\d{9}|\\d{12}$")) {
            employeeMap.put("identity_card", "Identity card is not valid!");
        }

        if (employee.getSalary() <= 0) {
            employeeMap.put("salary", "Salary can't be zero and lower than zero!");
        }

        if (employee.getPhoneNumber().equals("")) {
            employeeMap.put("phone", "Phone number can't be empty!");
        } else if (!employee.getPhoneNumber().matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")) {
            employeeMap.put("phone", "Phone number is not valid!");
        }

        if (employee.getEmail().equals("")) {
            employeeMap.put("email", "Email can't be empty!");
        } else if (!employee.getEmail().matches("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$")) {
            employeeMap.put("email", "Email is not valid!");
        }

        if (employeeMap.isEmpty()) {
            employeeRepository.insertEmployee(employee);
        }
        return employeeMap;
    }

    @Override
    public Employee searchEmployeeByID(int id) throws SQLException, ClassNotFoundException {
        return this.employeeRepository.searchEmployeeByID(id);
    }

    @Override
    public List<Employee> selectAllEmployee() throws SQLException, ClassNotFoundException {
        return this.employeeRepository.selectAllEmployee();
    }

    @Override
    public void updateEmployee(Employee customer) throws SQLException, ClassNotFoundException {
        this.employeeRepository.updateEmployee(customer);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> listNameEmployee(String name) throws SQLException, ClassNotFoundException {
        return this.employeeRepository.listNameEmployee(name);
    }
}
