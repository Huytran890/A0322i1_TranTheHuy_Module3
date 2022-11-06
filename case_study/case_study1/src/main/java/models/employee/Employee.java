package models.employee;

public class Employee {
    private Integer employeeID;
    private String name;
    private String dateOfBirth;
    private String identityCard;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private Integer positionID;     // vị trí(chức vụ)
    private Integer degreeID;        // trình độ
    private Integer departmentID;

    public Employee() {

    }

    public Employee(Integer employeeID, String name, String dateOfBirth, String identityCard, Double salary, String phoneNumber, String email, String address, Integer positionID, Integer degreeID, Integer departmentID) {
        this.employeeID = employeeID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.identityCard = identityCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.positionID = positionID;
        this.degreeID = degreeID;
        this.departmentID = departmentID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public Integer getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(Integer degreeID) {
        this.degreeID = degreeID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
