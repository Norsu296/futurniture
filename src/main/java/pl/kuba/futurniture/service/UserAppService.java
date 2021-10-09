package pl.kuba.futurniture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.model.UserApp;
import pl.kuba.futurniture.repository.UserAppRepository;

@Service
@RequiredArgsConstructor
public class UserAppService {

    private final UserAppRepository userAppRepository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(UserApp userApp){
        userApp.setPassword(passwordEncoder.encode(userApp.getPassword()));
        userAppRepository.save(userApp);
    }

}
