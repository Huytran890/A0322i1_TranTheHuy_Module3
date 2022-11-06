package service.employee_service;

import models.employee.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {
    List<Department> selectAll() throws SQLException, ClassNotFoundException;
}
