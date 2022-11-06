package service.Impl;

import models.Category;
import repository.CategoryRepository;
import repository.Impl.CategoryRepositoryImpl;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> showListCategory() {
        return this.categoryRepository.showListCategory();
    }
}
