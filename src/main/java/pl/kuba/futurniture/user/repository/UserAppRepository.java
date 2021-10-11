package pl.kuba.futurniture.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.futurniture.user.model.UserApp;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    Optional<UserApp> findByUsername(String username);

}
