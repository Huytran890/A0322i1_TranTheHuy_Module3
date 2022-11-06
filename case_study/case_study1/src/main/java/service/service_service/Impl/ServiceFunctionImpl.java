package service.service_service.Impl;

import models.service.Service;
import repository.service_repository.Impl.ServiceRepositoryImpl;
import repository.service_repository.ServiceRepository;
import service.service_service.ServiceFunction;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceFunctionImpl implements ServiceFunction {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();

    @Override
    public Map<String, String> insertServices(Service service) throws SQLException, ClassNotFoundException {
        Map<String, String> serviceMap = new HashMap<>();
        if (serviceMap.isEmpty()) {
            serviceRepository.insertServices(service);
        }
        return serviceMap;
    }

    @Override
    public List<Service> selectAllService() throws SQLException, ClassNotFoundException {
        return this.serviceRepository.selectAllService();
    }
}
