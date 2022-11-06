package repository.contract_repository.Impl;

import models.contract.Contract;
import repository.contract_repository.ContractRepository;
import utils.ConnectionUtils;
import utils.ContractConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {

    @Override
    public void insertContract(Contract contract) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ContractConstants.INSERT_CONTRACT);) {
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getDeposits());
            preparedStatement.setInt(4, contract.getEmployeeID());
            preparedStatement.setInt(5, contract.getCustomerID());
            preparedStatement.setInt(6, contract.getServiceID());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Contract> selectAllContract() throws SQLException, ClassNotFoundException {
        List<Contract> contractList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ContractConstants.SELECT_ALL_CONTRACT);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer contractId = resultSet.getInt("id_contract");
                String contractDate = resultSet.getString("date_making_contract");
                String endDate = resultSet.getString("date_finishing_contract");
                Double deposits = resultSet.getDouble("deposits");
                Integer employeeId = resultSet.getInt("id_employee");
                Integer customerId = resultSet.getInt("id_customer");
                Integer serviceId = resultSet.getInt("id_services");

                contractList.add(new Contract(contractId, contractDate, endDate, deposits, employeeId,
                        customerId, serviceId));
            }
        }
        return contractList;
    }

    private void printSQLException(SQLException ex) {
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
