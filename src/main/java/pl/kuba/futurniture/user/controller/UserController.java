package pl.kuba.futurniture.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba.futurniture.user.model.UserApp;
import pl.kuba.futurniture.user.model.UserRole;
import pl.kuba.futurniture.user.service.UserAppService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController {

    private final UserAppService userAppService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", userAppService.findAll());
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
        userAppService.addUser(userApp);
        return "user/user";
    }


    @ModelAttribute("userRoles")
    public List<String> userRoleList(){
        return Stream.of(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toList());
    }
}
