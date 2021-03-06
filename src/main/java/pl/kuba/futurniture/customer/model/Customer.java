package pl.kuba.futurniture.customer.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table (name = "customers")
@SQLDelete(sql = "UPDATE customers SET deleted = true WHERE id = ?")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20, message = "Imię musi mieć długość od 3 do 20 znaków!")
    private String name;

    @NotBlank
    @Size(min = 3, max = 20,  message = "Nazwisko musi mieć długość od 3 do 20 znaków!")
    private String surname;

    @NotBlank
    @Size(min = 3, max = 50, message = "Miasto musi mieć długość od 3 do 20 znaków!")
    private String city;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Kod pocztowy musi być podany w formacie 00-000")
    private String postCode;

    @NotBlank
    @Size(min = 3, max = 20, message = "Ulica musi mieć długość od 3 do 20 znaków!")
    private String street;

    @NotBlank
    private String number;

    private boolean deleted;

    @NotBlank
    @Size(min = 9, max = 10 , message = "Numer telefonu niepoprawny!")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @PrePersist
    public void deleted(){
        deleted = false;
    }
    public String getFullName(){
        return String.format("%s %s", this.name,this.surname);
    }

    public String getAddress(){
        return String.format("%s,%s,%s,%s", this.city, this.postCode, this.street, this.number);
    }
    public String getCustomerInformation(){
        return String.format("%s %s, %s %s %s",this.name,this.surname,this.city,this.street,this.number);
    }

}
