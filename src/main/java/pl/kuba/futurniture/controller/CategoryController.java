package pl.kuba.futurniture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findAllCategories(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "category";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @PostMapping("/add")
    public String addCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/app/category";
    }


}
