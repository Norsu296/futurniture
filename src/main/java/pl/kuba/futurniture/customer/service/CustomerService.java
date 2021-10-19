package pl.kuba.futurniture.customer.service;

import pl.kuba.futurniture.category.model.Category;
import pl.kuba.futurniture.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);
    void remove(Long id);
    List<Customer> findAll();
    Customer findById(Long id);
    public List<Customer> search(String keyword);

}
