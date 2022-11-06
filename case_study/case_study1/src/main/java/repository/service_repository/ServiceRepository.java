package repository.service_repository;

import models.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRepository {
    void insertServices(Service service) throws SQLException, ClassNotFoundException;

    List<Service> selectAllService() throws SQLException, ClassNotFoundException;
}
