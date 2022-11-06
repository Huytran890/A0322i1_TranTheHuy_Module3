package service.customer_service;

import models.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> selectAll() throws SQLException, ClassNotFoundException;
}
