package pl.kuba.futurniture.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.user.model.UserApp;
import pl.kuba.futurniture.user.model.UserRole;
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

    public boolean checkUserIsNotDefaultAdmin(Long id){
        if(userAppRepository.getById(id).getUsername().equals("admin")){
            return false;
        }else {
            return true;
        }
    }

    public void changeRole(Long id){
        UserApp userApp = userAppRepository.getById(id);
        if(userApp.getUserRole() == UserRole.ROLE_ADMIN){
            userApp.setUserRole(UserRole.ROLE_USER);
        }else{
            userApp.setUserRole(UserRole.ROLE_ADMIN);
        }
        userAppRepository.save(userApp);
    }

    public void block(Long id){
        UserApp userApp = userAppRepository.getById(id);
        userApp.setEnabled(!userApp.isEnabled());
        userAppRepository.save(userApp);
    }


    public List<UserApp> findAll(){
        return userAppRepository.findAll();
    }

}
