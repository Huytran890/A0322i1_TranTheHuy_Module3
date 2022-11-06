package utils;

public interface EmployeeConstants {

    String INSERT_EMPLOYEE = "insert into employee (name, dateOfBirth, identity_card," +
            "salary, phone_number, email, address, id_position, id_standard, id_part) " +
            "values (?,?,?,?,?,?,?,?,?,?);";

    String SELECT_ALL_EMPLOYEE = "select * from employee group by id_employee;";

    String SEARCH_EMPLOYEE_BY_ID = "select employee.id_employee,employee.name," +
            "employee.dateOfBirth,employee.identity_card,employee.salary,employee.phone_number,employee.email," +
            "employee.address,employee.id_position,employee.id_standard,employee.id_part " +
            "from employee inner join part on employee.id_part = part.id_part" +
            " inner join standard on employee.id_standard = standard.id_standard " +
            " inner join position on employee.id_position = position.id_position where id_employee=?";

    String UPDATE_EMPLOYEE = "update employee set name=?, dateOfBirth=?," +
            "identity_card=?, salary=?, phone_number=?, email=?, address=?, id_position=?, id_standard=?," +
            "id_part=? where id_employee=?;";

    String DELETE_EMPLOYEE = "delete from employee where id_employee = ?;";

    String LIST_EMPLOYEE_BY_NAME = "select * from employee" +
            " where name like ?;";
}
