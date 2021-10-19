package pl.kuba.futurniture.order.service;

import pl.kuba.futurniture.category.model.Category;
import pl.kuba.futurniture.order.model.Order;
import pl.kuba.futurniture.product.model.Product;

import java.util.List;

public interface OrderService {
    void save(Order order);
    void remove(Long id);
    List<Order> findAll();
    Order findById(Long id);

    List<Order> filterByStatus(String status);
    List<Product> findAvailableProducts();
    void take(Long id);
    boolean checkOrderStatusBeforeDeletion(Long id);
    List<Order> findAllByDeleted();
}
