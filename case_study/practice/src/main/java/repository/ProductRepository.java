package repository;

import models.Account;
import models.Product;
import models.ProductCollap;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    void addNewProduct(Product product);

    List<ProductCollap> showListProduct();

    boolean update(Product product) throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws ClassNotFoundException, SQLException;

    ProductCollap searchProductByID(int id);

    Account login(String user, String password);

    List<ProductCollap> searchProductByName(String name);

    List<ProductCollap> searchProductByPrice(double price);

    List<ProductCollap> sortByName();
}
