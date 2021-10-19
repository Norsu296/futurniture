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
public class UserAppServiceImpl implements UserAppService {

    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(UserApp userApp){
        userApp.setPassword(passwordEncoder.encode(userApp.getPassword()));
        userAppRepository.save(userApp);
    }
    public void edit(Long id, UserApp newUserApp){
        UserApp userApp = userAppRepository.findById(id).get();
        userApp.setUsername(newUserApp.getUsername());
        userApp.setUserRole(newUserApp.getUserRole());
        userApp.setEnabled(newUserApp.isEnabled());
        userAppRepository.save(userApp);
    }
    public UserApp findById(Long id){
        return userAppRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        userAppRepository.deleteById(id);
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


    public List<UserApp> findAll(){
        return userAppRepository.findAll();
    }

}
