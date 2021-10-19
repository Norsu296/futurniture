package pl.kuba.futurniture.user.service;

import pl.kuba.futurniture.category.model.Category;
import pl.kuba.futurniture.user.model.UserApp;

import java.util.List;

public interface UserAppService {

    void create(UserApp userApp);
    void edit(Long id, UserApp userApp);
    List<UserApp> findAll();
    UserApp findById(Long id);
    void remove(Long id);
    String loggedUser();
    boolean checkUserIsNotDefaultAdmin(Long id);

}
