package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kuba.futurniture.model.Category;
import pl.kuba.futurniture.model.Product;
import pl.kuba.futurniture.service.CategoryService;
import pl.kuba.futurniture.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/product")
@RequiredArgsConstructor
public class ProductController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("products",productService.findAll());
        return "product/product";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("product", new Product());
        return "product/product-add";
    }
    @PostMapping("/add")
    public String add(@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product/product-add";
        }
        productService.save(product);
        return "redirect:/app/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
            if(productService.checkProductBindings(id)){
                productService.remove(id);
            }else{
                redirectAttributes.addFlashAttribute("errorMessage", "Produkt jest przypisany do zamówienia, nie można usunąć!");
            }
        return "redirect:/app/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/product-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product/product-edit";
        }
       productService.save(product);
        return "redirect:/app/product";
    }

    @GetMapping("/available/{id}")
    public String available(@PathVariable Long id){
        productService.changeAvailable(id);
        return "redirect:/app/product";
    }

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }

}
