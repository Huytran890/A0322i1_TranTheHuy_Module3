package models.employee;

public class Degree {
    private Integer degreeID;
    private String degreeName;

    public Degree() {

    }

    public Degree(Integer degreeID, String degreeName) {
        this.degreeID = degreeID;
        this.degreeName = degreeName;
    }

    public Integer getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(Integer degreeID) {
        this.degreeID = degreeID;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
