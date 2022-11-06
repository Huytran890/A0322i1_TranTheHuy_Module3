package utils;

public interface ContractConstants {

    String INSERT_CONTRACT = "insert into contract (date_making_contract,date_finishing_contract,deposits," +
            "id_employee,id_customer,id_services) " +
            "values (?,?,?,?,?,?);";

    String SELECT_ALL_CONTRACT = "select * from contract group by id_contract;";

}
