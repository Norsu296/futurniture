package pl.kuba.futurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.model.Order;
import pl.kuba.futurniture.model.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
