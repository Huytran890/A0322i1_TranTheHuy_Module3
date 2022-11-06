package models.contract;

public class ContractDetail {
    private Integer contractDetailID;
    private int contractQuantity;

    public ContractDetail() {

    }

    public ContractDetail(Integer contractDetailID, int contractQuantity) {
        this.contractDetailID = contractDetailID;
        this.contractQuantity = contractQuantity;
    }

    public Integer getContractDetailID() {
        return contractDetailID;
    }

    public void setContractDetailID(Integer contractDetailID) {
        this.contractDetailID = contractDetailID;
    }

    public int getContractQuantity() {
        return contractQuantity;
    }

    public void setContractQuantity(int contractQuantity) {
        this.contractQuantity = contractQuantity;
    }
}
