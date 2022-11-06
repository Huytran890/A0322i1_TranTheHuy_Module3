package repository.customer_repository;

import models.customer.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    void addCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    Customer findCustomerByID (int id) throws SQLException, ClassNotFoundException;

    List<Customer> selectAllCustomer() throws SQLException, ClassNotFoundException;

    void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    void deleteCustomer(int id) throws SQLException, ClassNotFoundException;

    List<Customer> searchCustomer(String name, String customerType) throws SQLException, ClassNotFoundException;
}
