package models.employee;

public class Department {
    private Integer departmentID;
    private String departmentName;

    public Department() {

    }

    public Department(Integer departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentId() {
        return departmentID;
    }

    public void setDepartmentId(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
