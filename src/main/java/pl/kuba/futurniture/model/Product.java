package pl.kuba.futurniture.model;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

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

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @PrePersist
    public void available(){
        available = true;
    }

    public String getProductInformation(){
        return String.format("%s, %s, %s", this.name, this.description, this.category.getName());
    }

}
