package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.repository.ProductRepository;

@Controller
@RequestMapping("/app/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "product";
    }

}
