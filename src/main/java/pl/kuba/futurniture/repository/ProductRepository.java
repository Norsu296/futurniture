package pl.kuba.futurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
