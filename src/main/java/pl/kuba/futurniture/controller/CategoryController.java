package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.kuba.futurniture.model.Category;
import pl.kuba.futurniture.repository.CategoryRepository;


import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
    //Poprawić przekazywanie modelu do widoku
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model){
        if(categoryRepository.existsById(id)){
            try{
                categoryRepository.deleteById(id);
            }catch (Exception e){
                model.addAttribute("message", "Nie można usunąć kategorii która ma produkty!");
            }

        }
        return "redirect:/app/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id));
        return "category-edit";
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
