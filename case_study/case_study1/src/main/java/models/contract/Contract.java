package models.contract;

public class Contract {
    private Integer contractID;
    private String contractStartDate;
    private String contractEndDate;
    private Double deposits;
    private Integer employeeID;
    private Integer customerID;
    private Integer serviceID;

    public Contract() {

    }

    public Contract(Integer contractID, String contractStartDate, String contractEndDate, Double deposits, Integer employeeID, Integer customerID, Integer serviceID) {
        this.contractID = contractID;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.deposits = deposits;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.serviceID = serviceID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        this.contractID = contractID;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getDeposits() {
        return deposits;
    }

    public void setDeposits(Double deposits) {
        this.deposits = deposits;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }
}
