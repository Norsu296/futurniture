package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kuba.futurniture.service.OrderService;
import pl.kuba.futurniture.service.UserAppService;

import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final OrderService orderService;
    private final UserAppService userAppService;

    @GetMapping("/app")
    public String mainPage(Model model) {
        model.addAttribute("numberOfActiveOrders", orderService.filterByStatus("inprogress").size());
        model.addAttribute("numberOfDelayedOrders", orderService.filterByStatus("delayed").size());
        model.addAttribute("numberOfAllOrders", orderService.findAllByDeleted().size());
        model.addAttribute("waitingOrders", orderService.filterByStatus("accepted"));
        model.addAttribute("numberOfWaitingOrders", orderService.filterByStatus("accepted").size());
        model.addAttribute("loggedUser", userAppService.loggedUser());
        model.addAttribute("date", LocalDate.now());
        return "dashboard";
    }


}
