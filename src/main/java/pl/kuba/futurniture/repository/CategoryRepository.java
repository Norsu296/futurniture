package pl.kuba.futurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
