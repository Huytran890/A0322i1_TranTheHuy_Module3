package service.employee_service;

import models.employee.Degree;

import java.sql.SQLException;
import java.util.List;

public interface DegreeService {
    List<Degree> selectAll() throws SQLException, ClassNotFoundException;
}
