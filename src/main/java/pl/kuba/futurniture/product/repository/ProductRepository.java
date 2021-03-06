package pl.kuba.futurniture.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.product.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAvailable(Boolean availavle);
    List<Product> findAllByCategoryId(Long id);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% " +
            "OR p.description LIKE %:keyword%")
    List<Product> search(String keyword);

}
