package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.repository.CustomerRepository;

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

}
