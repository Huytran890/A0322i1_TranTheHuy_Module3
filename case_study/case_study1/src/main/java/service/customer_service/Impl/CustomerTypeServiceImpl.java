package service.customer_service.Impl;

import models.customer.CustomerType;
import repository.customer_repository.CustomerTypeRepository;
import repository.customer_repository.Imple.CustomerTypeRepositoryImpl;
import service.customer_service.CustomerTypeService;

import java.sql.SQLException;
import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> selectAll() throws SQLException, ClassNotFoundException {
        return this.customerTypeRepository.selectAllCustomerType();
    }
}
