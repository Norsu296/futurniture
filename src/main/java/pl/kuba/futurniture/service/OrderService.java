package pl.kuba.futurniture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.model.Customer;
import pl.kuba.futurniture.model.Order;
import pl.kuba.futurniture.model.OrderStatus;
import pl.kuba.futurniture.model.Product;
import pl.kuba.futurniture.repository.OrderRepository;
import pl.kuba.futurniture.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public void save(Order order){
        orderRepository.save(order);
    }
    public void remove(Long id){
        orderRepository.deleteById(id);
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        return orderRepository.findById(id).get();
    }
    public List<Order> findDelayed(){
        return orderRepository.findAllDelayedOrders(LocalDate.now());
    }
    public List<Order> findImportant(){
        return orderRepository.findByisImportantTrue();
    }
    public List<Order> findActive(){
        return orderRepository.findByisActiveTrue();
    }
    public List<Product> findAvailableProducts(){
        return productRepository.findAll()
                .stream()
                .filter(Product::isAvailable)
                .collect(Collectors.toList());
    }
    public void finish(Long id){
        Order order = orderRepository.getById(id);
        order.setActive(false);
        order.setEndDate(LocalDate.now());
        order.setOrderStatus(OrderStatus.ended);
        orderRepository.save(order);
    }

    public void take(Long id){
        Order order = orderRepository.getById(id);
        order.setOrderStatus(OrderStatus.inProgress);
        orderRepository.save(order);
    }

    public boolean checkOrderStatusBeforeDeletion(Long id){
        Order order = orderRepository.getById(id);
        if(order.getOrderStatus() == OrderStatus.accepted || order.getOrderStatus() == OrderStatus.inProgress){
            return false;
        }
        return true;
    }
}
