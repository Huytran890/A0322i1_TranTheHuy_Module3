package service.employee_service.Impl;

import models.employee.Position;
import repository.employee_repository.Impl.PositionRepositoryImpl;
import repository.employee_repository.PositionRepository;
import service.employee_service.PositionService;

import java.sql.SQLException;
import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> selectAll() throws SQLException, ClassNotFoundException {
        return this.positionRepository.selectAll();
    }
}
