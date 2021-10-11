package pl.kuba.futurniture.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.customer.model.Customer;
import pl.kuba.futurniture.customer.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(Customer customer){
        customerRepository.save(customer);
    }
    public void remove(Long id){
        customerRepository.deleteById(id);
    }
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }

}
