package repository.employee_repository;

import models.employee.Degree;

import java.sql.SQLException;
import java.util.List;

public interface DegreeRepository {
    List<Degree> selectAll() throws SQLException, ClassNotFoundException;
}
