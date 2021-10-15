package pl.kuba.futurniture.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kuba.futurniture.customer.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:keyword% " +
            "OR c.name LIKE %:keyword% " +
            "OR c.surname LIKE %:keyword% " +
            "OR c.city LIKE %:keyword% " +
            "OR c.street LIKE %:keyword% ")
    List<Customer> search(String keyword);


}
