package pl.kuba.futurniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainPageController {

    @GetMapping("/app")
    public String mainPage(){
        return "dashboard";
    }

}
