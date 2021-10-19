package pl.kuba.futurniture.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kuba.futurniture.order.service.OrderServiceImpl;
import pl.kuba.futurniture.user.service.UserAppServiceImpl;

import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final OrderServiceImpl orderServiceImpl;
    private final UserAppServiceImpl userAppServiceImpl;

    @GetMapping("/app")
    public String mainPage(Model model) {
        model.addAttribute("numberOfActiveOrders", orderServiceImpl.filterByStatus("inprogress").size());
        model.addAttribute("numberOfDelayedOrders", orderServiceImpl.filterByStatus("delayed").size());
        model.addAttribute("numberOfAllOrders", orderServiceImpl.findAllByDeleted().size());
        model.addAttribute("waitingOrders", orderServiceImpl.filterByStatus("accepted"));
        model.addAttribute("numberOfWaitingOrders", orderServiceImpl.filterByStatus("accepted").size());
        model.addAttribute("date", LocalDate.now());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "403";
    }


}
