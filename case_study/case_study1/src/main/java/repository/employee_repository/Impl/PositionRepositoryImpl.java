package repository.employee_repository.Impl;

import models.employee.Position;
import repository.employee_repository.PositionRepository;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    private static final String SELECT_ALL_POSITION = "select * from position";

    @Override
    public List<Position> selectAll() throws SQLException, ClassNotFoundException {
        List<Position> positionList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idPosition = resultSet.getInt("id_position");
                String namePosition = resultSet.getString("name_position");
                positionList.add(new Position(idPosition, namePosition));
            }
        }
        return positionList;
    }
}