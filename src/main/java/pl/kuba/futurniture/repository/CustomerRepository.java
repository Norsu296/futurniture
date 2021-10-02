package pl.kuba.futurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
