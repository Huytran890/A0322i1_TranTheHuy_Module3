package service.Impl;

import models.Account;
import models.Product;
import models.ProductCollap;
import repository.Impl.ProductRepositoryImpl;
import repository.ProductRepository;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public void addNewProduct(Product product) {
        this.productRepository.addNewProduct(product);
    }

    @Override
    public List<ProductCollap> showListProduct() {
        return this.productRepository.showListProduct();
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
        return this.productRepository.update(product);
    }

    @Override
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        return this.productRepository.delete(id);
    }

    public List<ProductCollap> searchProductByName(String name) {
        return this.productRepository.searchProductByName(name);
    }

    @Override
    public ProductCollap searchProductByID(int id) {
        return this.productRepository.searchProductByID(id);
    }

    public List<ProductCollap> searchProductByPrice(double price) {
        return this.productRepository.searchProductByPrice(price);
    }

    public List<ProductCollap> sortByName(){
        return this.productRepository.sortByName();
    }

    public Account login(String user, String password) {
        return this.productRepository.login(user, password);
    }
}
