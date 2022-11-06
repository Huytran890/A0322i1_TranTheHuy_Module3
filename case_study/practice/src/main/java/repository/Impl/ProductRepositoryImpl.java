package repository.Impl;

import models.Account;
import models.Product;
import models.ProductCollap;
import repository.ProductRepository;
import utils.AccountConstants;
import utils.ConnectionUtils;
import utils.ProductConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void addNewProduct(Product product) {
        System.out.println(ProductConstants.INSET_PRODUCT);
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductConstants.INSET_PRODUCT);) {
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setInt(3, product.getQuantity());
                statement.setString(4, product.getColor());
                statement.setString(5, product.getDescription());
                statement.setInt(6, product.getId_category());
                System.out.println(statement);
                statement.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductCollap> showListProduct() {
        List<ProductCollap> productList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductConstants.SELECT_PRODUCT_COMBINE);) {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String name_product = resultSet.getString(2);
                    double price_product = resultSet.getDouble(3);
                    int quantity_product = resultSet.getInt(4);
                    String color_product = resultSet.getString(5);
                    String description = resultSet.getString(5);
                    int id_category = resultSet.getInt(7);
                    String name_category = resultSet.getString(8);

                    productList.add(new ProductCollap(id_product, name_product, price_product, quantity_product,
                            color_product, description, id_category, name_category));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
        boolean rowUpdated;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductConstants.UPDATE_PRODUCT);) {
            System.out.println("Updated Product: " + statement);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getId_category());
            statement.setInt(7, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        boolean rowDeleted;
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(ProductConstants.DELETE_PRODUCT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public ProductCollap searchProductByID(int id) {
        ProductCollap productCollap = null;
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductConstants.SEARCH_PRODUCT_COMBINE);) {
                statement.setInt(1, id);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String name_product = resultSet.getString(2);
                    double price_product = resultSet.getDouble(3);
                    int quantity_product = resultSet.getInt(4);
                    String color_product = resultSet.getString(5);
                    String description = resultSet.getString(6);
                    int id_category = resultSet.getInt(7);
                    String name_category = resultSet.getString(8);

                    productCollap = new ProductCollap(id_product, name_product, price_product, quantity_product,
                            color_product, description, id_category, name_category);
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productCollap;
    }

    public List<ProductCollap> searchProductByName(String name) {
        List<ProductCollap> productList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductConstants.SEARCH_ALL_PRODUCT_COMBINE);) {
                statement.setString(1, name);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String name_product = resultSet.getString(2);
                    double price_product = resultSet.getDouble(3);
                    int quantity_product = resultSet.getInt(4);
                    String color_product = resultSet.getString(5);
                    String description = resultSet.getString(6);
                    int id_category = resultSet.getInt(7);
                    String name_category = resultSet.getString(8);

                    productList.add(new ProductCollap(id_product, name_product, price_product, quantity_product,
                            color_product, description, id_category, name_category));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<ProductCollap> searchProductByPrice(double price) {
        List<ProductCollap> productList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductConstants.SEARCH_ALL_PRODUCT_COMBINE);) {
                statement.setDouble(1, price);
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String name_product = resultSet.getString(2);
                    double price_product = resultSet.getDouble(3);
                    int quantity_product = resultSet.getInt(4);
                    String color_product = resultSet.getString(5);
                    String description = resultSet.getString(6);
                    int id_category = resultSet.getInt(7);
                    String name_category = resultSet.getString(8);

                    productList.add(new ProductCollap(id_product, name_product, price_product, quantity_product,
                            color_product, description, id_category, name_category));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }


    public Account login(String user, String password) {
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(AccountConstants.LOGIN_TO_WEBSITE);) {
                statement.setString(1, user);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return new Account(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductCollap> sortByName() {
        List<ProductCollap> productList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(ProductConstants.SORT_PRODUCTS_BY_NAME);) {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id_product = resultSet.getInt(1);
                    String name_product = resultSet.getString(2);
                    double price_product = resultSet.getDouble(3);
                    int quantity_product = resultSet.getInt(4);
                    String color_product = resultSet.getString(5);
                    String description = resultSet.getString(6);
                    int id_category = resultSet.getInt(7);
                    String name_category = resultSet.getString(8);
                    productList.add(new ProductCollap(id_product, name_product, price_product, quantity_product, color_product,
                            description, id_category, name_category));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
