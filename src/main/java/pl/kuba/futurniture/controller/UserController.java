package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.service.UserAppService;

@Controller
@RequestMapping("/app/user")
@RequiredArgsConstructor
public class UserController {

    private final UserAppService userAppService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userAppService.findAll());
        return "user/user";
    }

}
