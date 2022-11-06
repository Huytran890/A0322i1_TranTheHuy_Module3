package service.customer_service.Impl;

import repository.customer_repository.CustomerRepository;
import repository.customer_repository.Imple.CustomerRepositoryImpl;
import service.customer_service.CustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public Map<String, String> insertCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Map<String, String> customerMap = new HashMap<>();

        if (customer.getCustomerIdentityCard().equals("")) {
            customerMap.put("identity_card", "Identity card can't be empty!");
        } else if (!customer.getCustomerIdentityCard().matches("^\\d{9}|\\d{12}$")) {
            customerMap.put("identity_card", "Identity card is not valid!");
        }

        if (customer.getCustomerPhone().equals("")) {
            customerMap.put("phone", "Phone number can't be empty!");
        } else if (!customer.getCustomerPhone().matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")) {
            customerMap.put("phone", "Phone Number is not valid!");
        }

        if (customer.getCustomerEmail().equals("")) {
            customerMap.put("email", "Email can't be empty!");
        } else if (!customer.getCustomerEmail().matches("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$")) {
            customerMap.put("email", "Email is not valid!");
        }

        if (customerMap.isEmpty()) {
            customerRepository.addCustomer(customer);
        }
        return customerMap;
    }

    @Override
    public Customer searchCustomerByID(int id) throws SQLException, ClassNotFoundException {
        return this.customerRepository.findCustomerByID(id);
    }

    @Override
    public List<Customer> selectAllCustomer() throws SQLException, ClassNotFoundException {
        return this.customerRepository.selectAllCustomer();
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        this.customerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchCustomer(String name, String customerType) throws SQLException, ClassNotFoundException {
        return this.customerRepository.searchCustomer(name, customerType);
    }
}
