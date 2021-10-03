package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kuba.futurniture.model.Category;
import pl.kuba.futurniture.repository.CategoryRepository;


import javax.validation.Valid;

@Controller
@RequestMapping("/app/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category-add";
        }
        categoryRepository.save(category);
        return "redirect:/app/category";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
        return "redirect:/app/category";
    }
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id));
        return "category-add";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, @Valid Category category, BindingResult result){
        if(result.hasErrors()){
            return "category-edit";
        }
        Category editCategory = categoryRepository.findById(id).get();
        editCategory.setName(category.getName());
        categoryRepository.save(editCategory);
        return "redirect:/app/category";
    }


}
