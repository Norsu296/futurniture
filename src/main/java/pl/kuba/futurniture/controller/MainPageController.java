package pl.kuba.futurniture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/start")
@Controller
public class MainPageController {

    @GetMapping
    public String mainPage(){
        return "index";
    }

}
