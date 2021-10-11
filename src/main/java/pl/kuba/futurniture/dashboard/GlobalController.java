package pl.kuba.futurniture.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.kuba.futurniture.user.service.UserAppService;

import java.time.LocalDate;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalController {

    private final UserAppService userAppService;

    @ModelAttribute("loggedUser")
    public String loggedUser(){
        return userAppService.loggedUser();
    }
    @ModelAttribute("date")
    public LocalDate date(){
        return LocalDate.now();
    }


}
