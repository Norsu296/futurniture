package pl.kuba.futurniture.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 50, message = "Nazwa musi mieć minimum 3 znaki, maksymalnie 50!")
    private String name;
    private String description;
    @Column(columnDefinition = "int default 0")
    private Long popularity;
    @ManyToOne
    private Category category;




}
