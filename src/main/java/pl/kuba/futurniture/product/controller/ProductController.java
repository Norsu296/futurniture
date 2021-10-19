package pl.kuba.futurniture.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kuba.futurniture.category.model.Category;
import pl.kuba.futurniture.product.model.Product;
import pl.kuba.futurniture.category.service.CategoryServiceImpl;
import pl.kuba.futurniture.product.service.ProductServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/product")
@RequiredArgsConstructor
public class ProductController {

    private final CategoryServiceImpl categoryServiceImpl;
    private final ProductServiceImpl productServiceImpl;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("products", productServiceImpl.findAll());
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
        productServiceImpl.save(product);
        return "redirect:/app/product";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
            if(productServiceImpl.checkProductBindings(id)){
                productServiceImpl.remove(id);
            }else{
                redirectAttributes.addFlashAttribute("errorMessage", "Produkt jest przypisany do zamówienia, nie można usunąć!");
            }
        return "redirect:/app/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("product", productServiceImpl.findById(id));
        return "product/product-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product/product-edit";
        }
       productServiceImpl.save(product);
        return "redirect:/app/product";
    }

    @GetMapping("/available/{id}")
    public String available(@PathVariable Long id){
        productServiceImpl.changeAvailable(id);
        return "redirect:/app/product";
    }
    @GetMapping("/{available}")
    public String filterByAvailable(@PathVariable String available, Model model){
        model.addAttribute("products", productServiceImpl.filterByAvailable(available));
        return "product/product";
    }
    @GetMapping("/filter/{categoryId}")
    public String filterByCategory(@PathVariable Long categoryId, Model model){
        model.addAttribute("products", productServiceImpl.filterByCategory(categoryId));
        return "product/product";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword") String keyword, Model model){
        model.addAttribute("products", productServiceImpl.search(keyword));
        return "product/product";
    }

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryServiceImpl.findAll();
    }

}
