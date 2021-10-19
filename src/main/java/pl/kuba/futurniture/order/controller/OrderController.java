package pl.kuba.futurniture.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kuba.futurniture.customer.model.Customer;
import pl.kuba.futurniture.order.model.Order;
import pl.kuba.futurniture.product.model.Product;
import pl.kuba.futurniture.customer.service.CustomerServiceImpl;
import pl.kuba.futurniture.order.service.OrderServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;


    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("orders", orderServiceImpl.findAll());
        return "order/order";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderServiceImpl.findById(id));
        return "order/order-details";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("order", new Order());
        return "order/order-add";
    }

    @PostMapping("/add")
    public String add(@Valid Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "order/order-add";
        }
        orderServiceImpl.save(order);
        return "redirect:/app/order";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderServiceImpl.findById(id));
        return "order/order-edit";
    }

    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, @Valid Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "order/order-edit";
        }
        orderServiceImpl.save(order);
        return "redirect:/app/order";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (orderServiceImpl.checkOrderStatusBeforeDeletion(id)) {
            orderServiceImpl.remove(id);
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Nie można usunąć zamówienia w trakcie realizacji!");
        }
        return "redirect:/app/order";
    }

    @GetMapping("/end/{id}")
    public String endView(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderServiceImpl.findById(id));
        return "order/order-end";
    }

    @GetMapping("/end/{id}/print")
    public String print(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderServiceImpl.findById(id));
        return "order/order-print";
    }

    @GetMapping("/finish/{id}")
    public String finish(@PathVariable Long id) {
        orderServiceImpl.finish(id);
        return "redirect:/app/order";
    }

    @GetMapping("/{status}")
    public String filterByStatus(@PathVariable String status, Model model) {
        model.addAttribute("orders", orderServiceImpl.filterByStatus(status));
        return "order/order";
    }

    @GetMapping("/take/{id}")
    public String take(@PathVariable Long id) {
        orderServiceImpl.take(id);
        return "redirect:/app/order";
    }


    @ModelAttribute("customers")
    public List<Customer> customerList() {
        return customerServiceImpl.findAll();
    }

    @ModelAttribute("products")
    public List<Product> productList() {
        return orderServiceImpl.findAvailableProducts();
    }

}