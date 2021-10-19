package pl.kuba.futurniture.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kuba.futurniture.user.model.UserApp;
import pl.kuba.futurniture.user.model.UserRole;
import pl.kuba.futurniture.user.repository.UserAppRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAppRepository userAppRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(userAppRepository.findByUsername(s).isPresent()){
            UserApp userApp = userAppRepository.findByUsername(s).get();
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(userApp.getUserRole().toString()));
            return new User(userApp.getUsername(), userApp.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("Nie znaleziono użytkownika");
        }

    }
}
