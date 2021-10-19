package pl.kuba.futurniture.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.order.model.Order;
import pl.kuba.futurniture.order.model.OrderStatus;
import pl.kuba.futurniture.product.model.Product;
import pl.kuba.futurniture.order.repository.OrderRepository;
import pl.kuba.futurniture.product.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

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


    public List<Order> filterByStatus(String status){
        if(status.equals("accepted")){
            return orderRepository.findAllByOrderStatus(OrderStatus.accepted);
        }else if(status.equals("inprogress")){
            return orderRepository.findAllByOrderStatus(OrderStatus.inProgress);
        }else if(status.equals("ended")){
            return orderRepository.findAllByOrderStatus(OrderStatus.ended);
        }else if(status.equals("important")){
            return orderRepository.findByisImportantTrue();
        }else if(status.equals("delayed")){
            return orderRepository.findAllDelayedOrders(LocalDate.now());
        }else{
            return orderRepository.findAll();
        }

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

    public List<Order> findAllByDeleted() {
        return orderRepository.findAllByDeleted(false);
    }
}
