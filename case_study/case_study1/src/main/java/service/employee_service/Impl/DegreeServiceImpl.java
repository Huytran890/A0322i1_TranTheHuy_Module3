package service.employee_service.Impl;

import models.employee.Degree;
import repository.employee_repository.DegreeRepository;
import repository.employee_repository.Impl.DegreeRepositoryImpl;
import service.employee_service.DegreeService;

import java.sql.SQLException;
import java.util.List;

public class DegreeServiceImpl implements DegreeService {
    DegreeRepository degreeRepository = new DegreeRepositoryImpl();

    @Override
    public List<Degree> selectAll() throws SQLException, ClassNotFoundException {
        return this.degreeRepository.selectAll();
    }
}
