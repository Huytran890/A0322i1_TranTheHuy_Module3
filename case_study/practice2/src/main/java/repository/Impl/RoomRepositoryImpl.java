package repository.Impl;

import models.Account;
import models.Room;
import models.RoomCollapPayment;
import repository.RoomRepository;
import utils.AccountConstants;
import utils.ConnectionUtils;
import utils.RoomConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    @Override
    public void addNewRoom(Room room) {
        System.out.println(RoomConstants.INSET_ROOM);
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(RoomConstants.INSET_ROOM);) {
                statement.setString(1, room.getNameCustomer());
                statement.setString(2, room.getPhoneNumberCustomer());
                statement.setDate(3, new Date(room.getDateRent().getTime()));
                statement.setInt(4, room.getId_payment());
                statement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RoomCollapPayment> showListRoom() {
        List<RoomCollapPayment> roomList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(RoomConstants.SELECT_ROOM_COMBINE);) {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_room = resultSet.getInt(1);
                    String name_customer = resultSet.getString(2);
                    String phoneNumber = resultSet.getString(3);
                    java.util.Date dateRent = resultSet.getDate(4);
                    int id_payment = resultSet.getInt(5);
                    String name_payment = resultSet.getString(6);

                    roomList.add(new RoomCollapPayment(id_room, name_customer, phoneNumber, dateRent,
                            id_payment, name_payment));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(RoomConstants.DELETE_ROOM);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public RoomCollapPayment searchRoomByID(int id) {
        RoomCollapPayment roomCollapPayment = null;
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(RoomConstants.SEARCH_ROOM_COMBINE);) {
                statement.setInt(1, id);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_room = resultSet.getInt(1);
                    String name_customer = resultSet.getString(2);
                    String phoneNumber = resultSet.getString(3);
                    java.util.Date dateRent = resultSet.getDate(4);
                    int id_payment = resultSet.getInt(5);
                    String name_payment = resultSet.getString(6);

                    roomCollapPayment = new RoomCollapPayment(id_room, name_customer, phoneNumber,
                            dateRent, id_payment, name_payment);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return roomCollapPayment;
    }

    @Override
    public Account login(String user, String password) {
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(AccountConstants.LOGIN_TO_WEBSITE);) {
                statement.setString(1, user);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return new Account(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RoomCollapPayment> searchRoomByNameCustomer(String name) {
        List<RoomCollapPayment> roomCollapPayment = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(RoomConstants.SEARCH_ALL_PRODUCT_COMBINE);) {
                statement.setString(1, name);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_room = resultSet.getInt(1);
                    String name_customer = resultSet.getString(2);
                    String phoneNumber = resultSet.getString(3);
                    java.util.Date dateRent = resultSet.getDate(4);
                    int id_payment = resultSet.getInt(5);
                    String name_payment = resultSet.getString(6);

                    roomCollapPayment.add(new RoomCollapPayment(id_room, name_customer, phoneNumber,
                            dateRent, id_payment, name_payment));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return roomCollapPayment;
    }
}
