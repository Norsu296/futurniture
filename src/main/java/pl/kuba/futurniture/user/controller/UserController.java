package pl.kuba.futurniture.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kuba.futurniture.user.model.UserApp;
import pl.kuba.futurniture.user.model.UserRole;
import pl.kuba.futurniture.user.service.UserAppServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController {

    private final UserAppServiceImpl userAppServiceImpl;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userAppServiceImpl.findAll());
        return "user/user";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("userApp", new UserApp());
        return "user/user-add";
    }
    @PostMapping("/add")
    public String add(@Valid UserApp userApp, BindingResult result){
        if(result.hasErrors()){
            return "user/user-add";
        }
        System.out.println(userApp);
        userAppServiceImpl.create(userApp);
        return "redirect:/admin/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("userApp", userAppServiceImpl.findById(id));
        return "user/user-edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @Valid UserApp userApp, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "user/user-edit";
        }
        if(!userAppServiceImpl.checkUserIsNotDefaultAdmin(id)) {
            redirectAttributes.addFlashAttribute("error", "Użytkownik domyślny, nie można edytować!");
            return "redirect:/admin/user/edit/"+id;
        }
        userAppServiceImpl.edit(id, userApp);
        return "redirect:/admin/user";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userAppServiceImpl.remove(id);
        return "redirect:/admin/user";
    }

    @ModelAttribute("userRoles")
    public List<String> userRoleList(){
        return Stream.of(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toList());
    }
}
