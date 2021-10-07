package pl.kuba.futurniture.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50, message = "Nazwa musi mieć minimum 3 znaki, maksymalnie 50!")
    private String name;

    private String description;

    @Column(columnDefinition = "int default 0")
    private Long popularity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public String getProductInformation(){
        return String.format("%s, %s, %s", this.name, this.description, this.category.getName());
    }


}
