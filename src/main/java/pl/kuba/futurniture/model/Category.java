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
    @Size(min = 3, max = 30)
    private String name;
    @OneToMany
    List<Product> products;

}
