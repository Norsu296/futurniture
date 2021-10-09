package pl.kuba.futurniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba.futurniture.model.UserApp;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    Optional<UserApp> findByUsername(String username);

}
