package pl.kuba.futurniture.model;

import lombok.Data;

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
    @Size(min = 3, max = 20, message = "Imię musi mieć długość od 3 do 20 znaków!")
    private String name;
    @NotNull
    @Size(min = 3, max = 20,  message = "Nazwisko musi mieć długość od 3 do 20 znaków!")
    private String surname;
    @NotNull
    @Size(min = 3, max = 20, message = "Miasto musi mieć długość od 3 do 20 znaków!")
    private String city;
    @NotNull
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Kod pocztowy musi być podany w formacie 00-000")
    private String postCode;
    @NotNull
    @Size(min = 3, max = 20, message = "Ulica musi mieć długość od 3 do 20 znaków!")
    private String street;
    @NotNull
    private int number;
    @NotNull
    @Size(min = 9, max = 10 , message = "Numer telefonu niepoprawny!")
    private String phone;
    @NotNull
    @Email
    private String email;

    @OneToMany
    private List<Order> orders;

}
