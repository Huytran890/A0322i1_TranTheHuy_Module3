package service.employee_service;

import models.employee.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionService {
    List<Position> selectAll() throws SQLException, ClassNotFoundException;
}
