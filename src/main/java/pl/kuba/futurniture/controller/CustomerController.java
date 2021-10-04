package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.model.Customer;
import pl.kuba.futurniture.repository.CustomerRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customer";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-add";
    }
    @PostMapping("/add")
    public String add(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customer-add";
        }
        customerRepository.save(customer);
        return "redirect:/app/customer";
    }


}
