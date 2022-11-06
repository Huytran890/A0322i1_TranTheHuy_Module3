package models;

public class Payment {
    private int idPayment;
    private String namePayment;

    public Payment() {
    }

    public Payment(int idPayment, String namePayment) {
        this.idPayment = idPayment;
        this.namePayment = namePayment;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getNamePayment() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment = namePayment;
    }
}
