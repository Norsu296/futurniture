package pl.kuba.futurniture.product.service;

import pl.kuba.futurniture.category.model.Category;
import pl.kuba.futurniture.product.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);
    void remove(Long id);
    List<Product> findAll();
    Product findById(Long id);
    void changeAvailable(Long id);
    List<Product> filterByAvailable(String param);
    List<Product> filterByCategory(Long categoryId);
    boolean checkProductBindings(Long id);
    List<Product> search(String keyword);

}
