package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.model.Category;
import pl.kuba.futurniture.model.Product;
import pl.kuba.futurniture.repository.CategoryRepository;
import pl.kuba.futurniture.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "product";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }
    @PostMapping("/add")
    public String addCategory(@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product-add";
        }
        productRepository.save(product);
        return "redirect:/app/product";
    }

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

}
