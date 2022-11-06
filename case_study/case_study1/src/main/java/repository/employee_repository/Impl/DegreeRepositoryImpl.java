package repository.employee_repository.Impl;

import models.employee.Degree;
import repository.employee_repository.DegreeRepository;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DegreeRepositoryImpl implements DegreeRepository {
    private static final String SELECT_ALL_DEGREE = "select * from standard";

    @Override
    public List<Degree> selectAll() throws SQLException, ClassNotFoundException {
        List<Degree> degreeList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEGREE);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idDegree = resultSet.getInt("id_standard");
                String nameDegree = resultSet.getString("name_standard");
                degreeList.add(new Degree(idDegree, nameDegree));
            }
        }
        return degreeList;
    }
}
