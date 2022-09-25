package Utils;

public interface Constants {
    String SELECT_ALL_FROM_USERS = "Select * from users;";

    String INSERT_INTO_USERS = "Insert into users (name, email, country) values (?, ?, ?);";

    String UPDATE_USERS = "Update users set name = ?, email = ?, country = ? where id = ?;";

    String FIND_USERS_BY_ID = "Select * from users where id = ?;";

    String DELETE_USERS = "Delete from users where id = ?;";

    String SEARCH_USERS_BY_COUNTRY = "Select * from users where country like ?;";

    String SORT_USERS_BY_NAME = "Select * from users Order By name ASC";
}
