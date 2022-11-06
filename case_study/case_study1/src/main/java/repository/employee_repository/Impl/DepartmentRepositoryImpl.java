package repository.employee_repository.Impl;

import models.employee.Department;
import repository.employee_repository.DepartmentRepository;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static final String SELECT_ALL_DEPARTMENT = "select * from part";

    @Override
    public List<Department> selectAll() throws SQLException, ClassNotFoundException {
        List<Department> departmentList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENT);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idDepartment = resultSet.getInt("id_part");
                String nameDepartment = resultSet.getString("name_part");
                departmentList.add(new Department(idDepartment, nameDepartment));
            }
        }
        return departmentList;
    }
}
