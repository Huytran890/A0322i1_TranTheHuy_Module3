package repository.customer_repository;

import models.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface CustomerTypeRepository {
    List<CustomerType> selectAllCustomerType() throws SQLException, ClassNotFoundException;

    CustomerType findCustomerByID(int id) throws SQLException, ClassNotFoundException;
}
