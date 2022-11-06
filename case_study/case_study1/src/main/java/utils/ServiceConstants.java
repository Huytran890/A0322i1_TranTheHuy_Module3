package utils;

public interface ServiceConstants {

    String INSERT_SERVICE = "insert into services (name_services,area,rental_cost," +
            "max_people_available,room_standard,describe_other_convenient,area_swimming,number_of_floors," +
            "id_type_of_services,id_rental_type) " +
            "values (?,?,?,?,?,?,?,?,?,?);";

    String SELECT_ALL_SERVICES = "select * from services group by id_services;";
}
