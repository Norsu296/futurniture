package pl.kuba.futurniture.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.user.repository.UserAppRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAppRepository userAppRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(userAppRepository.findByUsername(s).isPresent()){
            return userAppRepository.findByUsername(s).get();
        } else {
            throw new UsernameNotFoundException("Nie znaleziono użytkownika");
        }

    }
}
