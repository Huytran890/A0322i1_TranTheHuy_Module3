package utils;

public interface RoomConstants {
    String INSET_ROOM = "insert into room (name_customer, phone_number, date_begin, id_payment) values (?,?,?,?)";
    String DELETE_ROOM = "delete from room where id_room=?";

    String SELECT_ROOM_COMBINE = "select r.id_room, r.name_customer, r.phone_number, r.date_begin, p.id_payment, p.name_payment from room r inner join payment p on r.id_payment= p.id_payment";
    String SEARCH_ROOM_COMBINE = "select r.id_room, r.name_customer, r.phone_number, r.date_begin, p.id_payment, p.name_payment from room r inner join payment p on r.id_payment= p.id_payment where id_room=?";
    String SEARCH_ALL_PRODUCT_COMBINE = "select r.id_room, r.name_customer, r.phone_number, r.date_begin, p.id_payment, p.name_payment from room r inner join payment p on r.id_payment= p.id_payment where r.name_customer like?";
}
