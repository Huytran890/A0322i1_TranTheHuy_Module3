package repository;

import models.Account;
import models.Room;
import models.RoomCollapPayment;

import java.sql.SQLException;
import java.util.List;

public interface RoomRepository {

    void addNewRoom(Room room);

    List<RoomCollapPayment> showListRoom();

    boolean delete(int id) throws ClassNotFoundException, SQLException;

    RoomCollapPayment searchRoomByID(int id);

    Account login(String user, String password);

    List<RoomCollapPayment> searchRoomByNameCustomer(String name);
}
