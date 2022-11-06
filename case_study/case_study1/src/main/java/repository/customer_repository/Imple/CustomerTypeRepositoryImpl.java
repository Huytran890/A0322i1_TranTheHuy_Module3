package repository.customer_repository.Imple;

import models.customer.CustomerType;
import repository.customer_repository.CustomerTypeRepository;
import utils.ConnectionUtils;
import utils.CustomerConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMERS_TYPE = "select * from type_customer";
    private static final String FIND_CUSTOMER_TYPE_BY_ID = "select * from type_customer where id_typeOfCustomer=?";

    @Override
    public List<CustomerType> selectAllCustomerType() throws SQLException, ClassNotFoundException {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS_TYPE);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idCustomerType = resultSet.getInt(1);
                String nameCustomerType = resultSet.getString(2);
                customerTypeList.add(new CustomerType(idCustomerType, nameCustomerType));
            }
        }
        return customerTypeList;
    }

    public CustomerType findByID(int id) throws SQLException, ClassNotFoundException {
        CustomerType customerType = null;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_CUSTOMER_TYPE_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String customerName = resultSet.getString(1);
                return customerType = new CustomerType(id, customerName);
            }
        }
        return null;
    }
}