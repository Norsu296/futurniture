package pl.kuba.futurniture.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kuba.futurniture.customer.model.Customer;
import pl.kuba.futurniture.customer.service.CustomerServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/app/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("customers", customerServiceImpl.findAll());
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
        customerServiceImpl.save(customer);
        return "redirect:/app/customer";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerServiceImpl.findById(id));
        return "customer/customer-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "customer/customer-edit";
        }
        customerServiceImpl.save(customer);
        return "redirect:/app/customer";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
            customerServiceImpl.remove(id);
        return "redirect:/app/customer";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword") String keyword, Model model){
        model.addAttribute("customers", customerServiceImpl.search(keyword));
        return "customer/customer";
    }


}
