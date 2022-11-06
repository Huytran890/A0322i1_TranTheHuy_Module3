package repository.employee_repository;

import models.employee.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionRepository {
    List<Position> selectAll() throws SQLException, ClassNotFoundException;
}
