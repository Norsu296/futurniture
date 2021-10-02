package pl.kuba.futurniture.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Size(min = 3, max = 20)
    private String surname;
    @NotNull
    @Size(min = 3, max = 20)
    private String city;
    @NotNull
    @Pattern(regexp = "\\d{2}-\\d{3}")
    private String postCode;
    @NotNull
    @Size(min = 3, max = 20)
    private String street;
    @NotNull
    private int number;
    @NotNull
    @Size(min=0,max=10)
    private String phone;
    @Email
    private String email;

    @OneToMany
    private List<Order> orders;

}
