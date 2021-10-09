package pl.kuba.futurniture.repository;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.model.Order;
import pl.kuba.futurniture.model.OrderStatus;
import pl.kuba.futurniture.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    List<Order> findByisImportantTrue();
    @Query("SELECT o FROM Order o WHERE o.shipDate < :now AND o.orderStatus = 'inProgress'")
    List<Order> findAllDelayedOrders(@Param("now") LocalDate now);
    List<Order> findAllByOrderStatus(OrderStatus orderStatus);
    List<Order> findAllByDeleted(boolean deleted);
    Optional<Order> findByProductsId(Long id);

}
