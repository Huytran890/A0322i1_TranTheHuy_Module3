package repository.service_repository.Impl;

import models.service.Service;
import repository.service_repository.ServiceRepository;
import utils.ConnectionUtils;
import utils.ServiceConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {

    @Override
    public void insertServices(Service service) throws SQLException, ClassNotFoundException {
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ServiceConstants.INSERT_SERVICE);) {
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getServiceArea());
            preparedStatement.setDouble(3, service.getServiceCosts());
            preparedStatement.setInt(4, service.getMaxPeople());
            preparedStatement.setString(5, service.getStandardRoom());
            preparedStatement.setString(6, service.getConvenientOther());
            preparedStatement.setDouble(7, service.getAreaPool());
            preparedStatement.setInt(8, service.getNumberFloors());
            preparedStatement.setInt(9, service.getTypeServiceID());
            preparedStatement.setInt(10, service.getTypeRentID());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Service> selectAllService() throws SQLException, ClassNotFoundException {
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ServiceConstants.SELECT_ALL_SERVICES);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer serviceID = resultSet.getInt("id_services");
                String serviceName = resultSet.getString("name_services");
                Integer area = resultSet.getInt("area");
                Double costs = resultSet.getDouble("rental_cost");
                Integer peopleMax = resultSet.getInt("max_people_available");
                String standardRoom = resultSet.getString("room_standard");
                String convenientOther = resultSet.getString("describe_other_convenient");
                Double areaPool = resultSet.getDouble("area_swimming");
                Integer numberFloor = resultSet.getInt("number_of_floors");
                Integer typeServiceId = resultSet.getInt("id_type_of_services");
                Integer typeRentId = resultSet.getInt("id_rental_type");

                serviceList.add(new Service(serviceID, serviceName, area, costs, peopleMax,
                        standardRoom, convenientOther, areaPool, numberFloor, typeServiceId, typeRentId));
            }
        }
        return serviceList;
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
