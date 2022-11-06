package utils;

public interface StudentConstants {
    String INSERT_STUDENTS = "insert into student (name, gender, dob) values (?,?,?)";

    String UPDATE_STUDENTS = "update student set name=?, gender=?, dob=? where id=?";

    String DELETE_STUDENTS = "delete from student where id=?";

    String SELECT_ALL_STUDENTS = "select * from student";

    String SEARCH_STUDENTS_BY_ID = "select * from student where id=?";

    String SEARCH_STUDENTS_BY_NAME = "select * from student where name=?";
}
