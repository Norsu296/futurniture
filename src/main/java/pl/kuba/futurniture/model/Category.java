package pl.kuba.futurniture.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, message = "Kategoria musi mieć conajmniej 3 znaki!")
    private String name;
    @OneToMany
    @JoinColumn(name="product_id")
    List<Product> products;

}
