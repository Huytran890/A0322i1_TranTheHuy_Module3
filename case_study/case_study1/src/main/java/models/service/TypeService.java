package models.service;

public class TypeService {
    private Integer typeServiceID;
    private String typeServiceName;

    public TypeService() {

    }

    public TypeService(Integer typeServiceID, String typeServiceName) {
        this.typeServiceID = typeServiceID;
        this.typeServiceName = typeServiceName;
    }

    public Integer getTypeServiceID() {
        return typeServiceID;
    }

    public void setTypeServiceID(Integer typeServiceID) {
        this.typeServiceID = typeServiceID;
    }

    public String getTypeServiceName() {
        return typeServiceName;
    }

    public void setTypeServiceName(String typeServiceName) {
        this.typeServiceName = typeServiceName;
    }
}
