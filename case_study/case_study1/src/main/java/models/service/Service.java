package models.service;

public class Service {
    private Integer serviceID;
    private String serviceName;
    private Integer serviceArea;
    private Double serviceCosts;
    private Integer maxPeople;
    private String standardRoom;
    private String convenientOther;
    private Double areaPool;
    private Integer numberFloors;
    private Integer typeRentID;
    private Integer typeServiceID;

    public Service(){

    }

    public Service(Integer serviceID, String serviceName, Integer serviceArea, Double serviceCosts, Integer maxPeople, String standardRoom, String convenientOther, Double areaPool, Integer numberFloors, Integer typeRentID, Integer typeServiceID) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCosts = serviceCosts;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.convenientOther = convenientOther;
        this.areaPool = areaPool;
        this.numberFloors = numberFloors;
        this.typeRentID = typeRentID;
        this.typeServiceID = typeServiceID;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCosts() {
        return serviceCosts;
    }

    public void setServiceCosts(Double serviceCosts) {
        this.serviceCosts = serviceCosts;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenientOther() {
        return convenientOther;
    }

    public void setConvenientOther(String convenientOther) {
        this.convenientOther = convenientOther;
    }

    public Double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(Double areaPool) {
        this.areaPool = areaPool;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public Integer getTypeRentID() {
        return typeRentID;
    }

    public void setTypeRentID(Integer typeRentID) {
        this.typeRentID = typeRentID;
    }

    public Integer getTypeServiceID() {
        return typeServiceID;
    }

    public void setTypeServiceID(Integer typeServiceID) {
        this.typeServiceID = typeServiceID;
    }
}
