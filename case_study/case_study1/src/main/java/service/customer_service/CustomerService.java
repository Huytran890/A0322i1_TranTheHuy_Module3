package service.customer_service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    Map<String, String> insertCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    Customer searchCustomerByID(int id) throws SQLException, ClassNotFoundException;

    List<Customer> selectAllCustomer() throws SQLException, ClassNotFoundException;

    void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    void deleteCustomer(int id) throws SQLException, ClassNotFoundException;

    List<Customer> searchCustomer(String name, String customerType) throws SQLException, ClassNotFoundException;
}
