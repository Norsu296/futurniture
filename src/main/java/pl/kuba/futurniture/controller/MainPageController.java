package pl.kuba.futurniture.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.repository.OrderRepository;

import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final OrderRepository orderRepository;

    @GetMapping("/app")
    public String mainPage(Model model){
        model.addAttribute("activeOrders", orderRepository.findByisActiveTrue());
        model.addAttribute("numberOfActiveOrders", orderRepository.findByisActiveTrue().size());
        model.addAttribute("numberOfDelayedOrders", orderRepository.findAllDelayedOrders(LocalDate.now()).size());
        model.addAttribute("numberOfAllOrders", orderRepository.findAll().size());
        model.addAttribute("lastOrders",orderRepository.findTop5ByOrderByStartDateDesc());
        return "dashboard";
    }


}
