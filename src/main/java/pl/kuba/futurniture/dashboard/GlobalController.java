package pl.kuba.futurniture.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.kuba.futurniture.user.service.UserAppServiceImpl;

import java.time.LocalDate;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalController {

    private final UserAppServiceImpl userAppServiceImpl;
    private final PasswordEncoder passwordEncoder;

    @ModelAttribute("loggedUser")
    public String loggedUser(){
        return userAppServiceImpl.loggedUser();
    }
    @ModelAttribute("date")
    public LocalDate date(){
        return LocalDate.now();
    }


}
