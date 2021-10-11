package pl.kuba.futurniture.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.customer.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
