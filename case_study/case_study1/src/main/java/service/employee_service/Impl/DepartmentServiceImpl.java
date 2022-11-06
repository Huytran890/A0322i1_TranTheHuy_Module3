package service.employee_service.Impl;

import models.employee.Department;
import repository.employee_repository.DepartmentRepository;
import repository.employee_repository.Impl.DepartmentRepositoryImpl;
import service.employee_service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> selectAll() throws SQLException, ClassNotFoundException {
        return this.departmentRepository.selectAll();
    }
}
