package repository.Impl;

import models.Category;
import repository.CategoryRepository;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final String SELECT_ALL_CATEGORY = "select id_category, name_category from category";

    @Override
    public List<Category> showListCategory() {
        List<Category> categoryList = new ArrayList<>();
        try {
            try (Connection connection = ConnectionUtils.getConnection();
                 PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    categoryList.add(new Category(id, name));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
