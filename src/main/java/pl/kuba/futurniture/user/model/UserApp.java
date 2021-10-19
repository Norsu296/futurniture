package pl.kuba.futurniture.user.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "users_app")
@SQLDelete(sql = "UPDATE users_app SET deleted = true WHERE id = ?")
@Data
public class UserApp implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 30, message = "Nazwa użytkownika nie może być krótsza niż 3 znaki i dłuższa niż 30 znaków")
    private String username;
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private boolean isEnabled;
    private boolean deleted;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @PrePersist
    public void prePersist(){
        isEnabled = true;
    }
}
