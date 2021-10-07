package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kuba.futurniture.model.Customer;
import pl.kuba.futurniture.model.Order;
import pl.kuba.futurniture.model.Product;
import pl.kuba.futurniture.repository.CustomerRepository;
import pl.kuba.futurniture.repository.OrderRepository;
import pl.kuba.futurniture.repository.ProductRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/app/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("orders",orderRepository.findAll());
        return "order";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("order",orderRepository.findById(id).get());
        return "order-details";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("order", new Order());
        return "order-add";
    }

    @PostMapping("/add")
    public String add(@Valid Order order, BindingResult result){
        if(result.hasErrors()){
            return "order-add";
        }
        orderRepository.save(order);
        return "redirect:/app/order";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("order", orderRepository.findById(id).get());
        return "order-edit";
    }

    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, @Valid Order order, BindingResult result){
        if(result.hasErrors()){
            return "order-edit";
        }
        orderRepository.save(order);
        return "redirect:/app/order";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
        }
        return "redirect:/app/order";
    }

    @GetMapping("/end/{id}")
    public String endView(@PathVariable Long id, Model model){
        model.addAttribute("order", orderRepository.findById(id).get());
        return "order-end";
    }

    @GetMapping("/end/{id}/print")
    public String print(@PathVariable Long id, Model model){
        model.addAttribute("order", orderRepository.findById(id).get());
        return "order-print";
    }
    @GetMapping("/finish/{id}")
    public String finish(@PathVariable Long id){
        if(orderRepository.existsById(id)){
            Order order = orderRepository.getById(id);
            order.setActive(false);
            order.setEndDate(LocalDate.now());
            orderRepository.save(order);
        }
        return "redirect:/app/order";
    }

    @ModelAttribute("customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @ModelAttribute("products")
    public List<Product> productList(){
        return productRepository.findAll();
    }

}
