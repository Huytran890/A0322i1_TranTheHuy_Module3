package repository.Impl;

import models.Payment;
import repository.PaymentRepository;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {
    private final String SELECT_ALL_Payment = "select id_payment, name_payment from payment";

    @Override
    public List<Payment> showListPayment() {
        List<Payment> paymentList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(SELECT_ALL_Payment);) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    paymentList.add(new Payment(id, name));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return paymentList;
    }
}
