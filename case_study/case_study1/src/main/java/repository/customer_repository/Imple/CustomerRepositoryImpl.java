package repository.customer_repository.Imple;

import models.customer.Customer;
import models.customer.CustomerType;
import repository.customer_repository.CustomerRepository;
import repository.customer_repository.CustomerTypeRepository;
import utils.ConnectionUtils;
import utils.CustomerConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CustomerConstants.INSERT_CUSTOMER);) {
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdentityCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerType().getCustomerTypeID());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Customer findCustomerByID(int id) throws SQLException, ClassNotFoundException {
        Customer customer = null;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CustomerConstants.FIND_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String customerName = resultSet.getString(1);
                String customerBirthday = resultSet.getString(2);
                Integer customerGender = resultSet.getInt(3);
                String customerIdentityCard = resultSet.getString(4);
                String customerPhone = resultSet.getString(5);
                String customerEmail = resultSet.getString(6);
                String customerAddress = resultSet.getString(7);
                Integer customerTypeID = resultSet.getInt("id_typeOfCustomer");
                CustomerType customerType = customerTypeRepository.findCustomerByID(customerTypeID);
                customer = new Customer(id, customerName, customerBirthday, customerGender,
                        customerIdentityCard, customerPhone, customerEmail, customerAddress, customerType);
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> selectAllCustomer() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(CustomerConstants.SELECT_ALL_CUSTOMER);) {

            while (resultSet.next()) {
                Integer customerID = resultSet.getInt(1);
                String customerName = resultSet.getString(2);
                String customerBirthDay = resultSet.getString(3);
                Integer customerGender = Integer.valueOf(resultSet.getString(4));
                String customerIdCard = resultSet.getString(5);
                String customerPhone = resultSet.getString(6);
                String customerEmail = resultSet.getString(7);
                String customerAddress = resultSet.getString(8);
                Integer customerTypeID = resultSet.getInt(9);
                CustomerType customerType = customerTypeRepository.findCustomerByID(customerTypeID);

                customerList.add(new Customer(customerID, customerName, customerBirthDay, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerType));
            }
        }
        return customerList;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CustomerConstants.UPDATE_CUSTOMER);) {

            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdentityCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerType().getCustomerTypeID());
            preparedStatement.setInt(9, customer.getCustomerID());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CustomerConstants.DELETE_CUSTOMER);) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }


    @Override
    public List<Customer> searchCustomer(String name, String customerType) throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CustomerConstants.SEARCH_CUSTOMER);) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, customerType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer customerId = resultSet.getInt(1);
                String customerName = resultSet.getString(2);
                String customerBirthDay = resultSet.getString(3);
                Integer customerGender = Integer.valueOf(resultSet.getString(4));
                String customerIdCard = resultSet.getString(5);
                String customerPhone = resultSet.getString(6);
                String customerEmail = resultSet.getString(7);
                String customerAddress = resultSet.getString(8);
                Integer customerTypeID = resultSet.getInt(9);
                CustomerType customerType = customerTypeRepository.findCustomerByID(customerTypeID);

                customerList.add(new Customer(customerId, customerName, customerBirthDay, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress, customerType));
            }
        }
        return customerList;
    }

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
