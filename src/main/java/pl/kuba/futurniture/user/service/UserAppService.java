package pl.kuba.futurniture.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.user.model.UserApp;
import pl.kuba.futurniture.user.repository.UserAppRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAppService {

    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(UserApp userApp){
        userApp.setPassword(passwordEncoder.encode(userApp.getPassword()));
        userAppRepository.save(userApp);
    }

    public String loggedUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return  ((UserDetails) principal).getUsername();
        }else {
            return principal.toString();
        }
    }

    public List<UserApp> findAll(){
        return userAppRepository.findAll();
    }

}
