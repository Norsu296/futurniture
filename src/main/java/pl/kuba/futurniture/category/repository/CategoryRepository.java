package pl.kuba.futurniture.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
