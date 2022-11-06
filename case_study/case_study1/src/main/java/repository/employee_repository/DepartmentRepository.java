package repository.employee_repository;

import models.employee.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentRepository {
    List<Department> selectAll() throws SQLException, ClassNotFoundException;
}
