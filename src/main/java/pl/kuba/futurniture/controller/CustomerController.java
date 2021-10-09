package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.model.Customer;
import pl.kuba.futurniture.repository.CustomerRepository;
import pl.kuba.futurniture.service.CustomerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "customer/customer";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customer-add";
    }
    @PostMapping("/add")
    public String add(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customer/customer-add";
        }
        customerService.save(customer);
        return "redirect:/app/customer";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "customer/customer-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customer/customer-edit";
        }
        customerService.save(customer);
        return "redirect:/app/customer";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
            customerService.remove(id);
        return "redirect:/app/customer";
    }


}
