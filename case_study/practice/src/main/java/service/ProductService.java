package service;

import models.Account;
import models.Product;
import models.ProductCollap;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    void addNewProduct(Product product);

    List<ProductCollap> showListProduct();

    boolean update(Product product) throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws ClassNotFoundException, SQLException;

    ProductCollap searchProductByID(int id);

    List<ProductCollap> searchProductByName(String name);

    List<ProductCollap> searchProductByPrice(double price);

    Account login(String user, String password);

    List<ProductCollap> sortByName();
}
