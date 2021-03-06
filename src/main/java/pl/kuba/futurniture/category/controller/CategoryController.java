package pl.kuba.futurniture.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kuba.futurniture.category.model.Category;
import pl.kuba.futurniture.category.service.CategoryServiceImpl;


import javax.validation.Valid;

@Controller
@RequestMapping("/app/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("categories", categoryServiceImpl.findAll());
        return "category/category";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("category", new Category());
        return "category/category-add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/category-add";
        }
        categoryServiceImpl.save(category);
        return "redirect:/app/category";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes redirectAttributes){
            if(categoryServiceImpl.checkCategoryBindings(id)){
                categoryServiceImpl.remove(id);
            }else{
                redirectAttributes.addFlashAttribute("errorMessage", "Nie można usunąć kategorii która ma produkty!");
            }

        return "redirect:/app/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryServiceImpl.findById(id));
        return "category/category-edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, @Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category/category-edit";
        }
        categoryServiceImpl.save(category);
        return "redirect:/app/category";
    }



}
