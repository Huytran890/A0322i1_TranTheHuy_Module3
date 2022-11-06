package models;

import java.util.Date;

public class RoomCollapPayment {
    private int roomID;
    private String nameCustomer;
    private String phoneNumberCustomer;
    private Date dateRent;
    private int id_payment;
    private String name_payment;

    public RoomCollapPayment() {
    }

    public RoomCollapPayment(int roomID, String nameCustomer, String phoneNumberCustomer, Date dateRent, int id_payment, String name_payment) {
        this.roomID = roomID;
        this.nameCustomer = nameCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.dateRent = dateRent;
        this.id_payment = id_payment;
        this.name_payment = name_payment;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }

    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    public String getName_payment() {
        return name_payment;
    }

    public void setName_payment(String name_payment) {
        this.name_payment = name_payment;
    }
}
