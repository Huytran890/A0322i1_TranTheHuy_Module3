package service.service_service;

import models.service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ServiceFunction {
    public Map<String, String> insertServices(Service service) throws SQLException, ClassNotFoundException;

    public List<Service> selectAllService() throws SQLException, ClassNotFoundException;

}
