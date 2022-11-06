package models.employee;

public class Position {
    private Integer positionID;
    private String positionName;

    public Position(){

    }

    public Position(Integer positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
