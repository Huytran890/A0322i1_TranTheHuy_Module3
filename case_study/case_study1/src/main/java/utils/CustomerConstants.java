package utils;

public interface CustomerConstants {

    String INSERT_CUSTOMER = "insert into customer (name_customer,dateOfBirth_customer,sex," +
            "identity_card_customer,phone_number_customer,email,address,id_typeOfCustomer) values (?,?,?,?,?,?,?,?);";

    String FIND_CUSTOMER_BY_ID = "select * from customer inner join type_customer " +
            "on customer.id_typeOfCustomer = type_customer.id_typeOfCustomer where id_customer = ?";

    String SELECT_ALL_CUSTOMER = "select * from customer group by name_customer;";

    String UPDATE_CUSTOMER = "update customer set name_customer=?, dateOfBirth_customer=?," +
            "sex=?,identity_card_customer=?, phone_number_customer=?, email=?, address=?, " +
            "id_typeOfCustomer=? where id_customer = ?;";

    String DELETE_CUSTOMER = "delete from customer where id_customer = ?;";

    String SEARCH_CUSTOMER = "select * from customer" +
            " where name_customer like ? and id_typeOfCustomer like ?;";
}
