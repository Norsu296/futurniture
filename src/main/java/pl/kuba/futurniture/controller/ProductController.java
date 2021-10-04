package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String add(@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product-add";
        }
        productRepository.save(product);
        return "redirect:/app/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
        return "redirect:/app/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", productRepository.findById(id));
        return "product-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product-edit";
        }
       productRepository.save(product);
        return "redirect:/app/product";
    }

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

}
