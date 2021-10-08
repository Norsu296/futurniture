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
import pl.kuba.futurniture.service.CustomerService;
import pl.kuba.futurniture.service.OrderService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;


    @GetMapping
    public String findAll(Model model){
        model.addAttribute("orders",orderService.findAll());
        return "order";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("order",orderService.findById(id));
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
        orderService.save(order);
        return "redirect:/app/order";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("order", orderService.findById(id));
        return "order-edit";
    }

    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, @Valid Order order, BindingResult result){
        if(result.hasErrors()){
            return "order-edit";
        }
        orderService.save(order);
        return "redirect:/app/order";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        orderService.remove(id);
        return "redirect:/app/order";
    }

    @GetMapping("/end/{id}")
    public String endView(@PathVariable Long id, Model model){
        model.addAttribute("order", orderService.findById(id));
        return "order-end";
    }

    @GetMapping("/end/{id}/print")
    public String print(@PathVariable Long id, Model model){
        model.addAttribute("order", orderService.findById(id));
        return "order-print";
    }
    @GetMapping("/finish/{id}")
    public String finish(@PathVariable Long id){
        orderService.finish(id);
        return "redirect:/app/order";
    }

    @GetMapping("/delay")
    public String delayed(Model model){
        model.addAttribute("ordersDelay", orderService.findDelayed());
        return "order-delay";
    }
    @GetMapping("/important")
    public String important(Model model){
        model.addAttribute("ordersImportant", orderService.findImportant());
        return "order-important";
    }
    @GetMapping("/active")
    public String active(Model model){
        model.addAttribute("ordersActive", orderService.findActive());
        return "order-active";
    }


    @ModelAttribute("customers")
    public List<Customer> customerList(){
        return customerService.findAll();
    }

    @ModelAttribute("products")
    public List<Product> productList(){
        return orderService.findAvailableProducts();
    }

}
