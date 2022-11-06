package repository.contract_repository;

import models.contract.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {
    void insertContract(Contract contract) throws SQLException, ClassNotFoundException;

    List<Contract> selectAllContract() throws SQLException, ClassNotFoundException;
}
