package pl.kuba.futurniture.category.service;

import pl.kuba.futurniture.category.model.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);
    void remove(Long id);
    List<Category> findAll();
    Category findById(Long id);
    boolean checkCategoryBindings(Long id);

}
