package pl.kuba.futurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAvailable(Boolean availavle);
    List<Product> findAllByCategoryId(Long id);

}
