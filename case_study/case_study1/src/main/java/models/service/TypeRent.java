package models.service;

public class TypeRent {
    private Integer typeRentID;
    private String typeRentName;

    public TypeRent() {

    }

    public TypeRent(Integer typeRentID, String typeRentName) {
        this.typeRentID = typeRentID;
        this.typeRentName = typeRentName;
    }

    public Integer getTypeRentID() {
        return typeRentID;
    }

    public void setTypeRentID(Integer typeRentID) {
        this.typeRentID = typeRentID;
    }

    public String getTypeRentName() {
        return typeRentName;
    }

    public void setTypeRentName(String typeRentName) {
        this.typeRentName = typeRentName;
    }
}
