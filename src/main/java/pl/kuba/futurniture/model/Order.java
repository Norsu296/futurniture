package pl.kuba.futurniture.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "is_paid")
    private boolean isPaid;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "ship_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate shipDate;

    @NotNull
    @Column(name = "is_important")
    private boolean isImportant;

    @NotNull
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;

    @NotNull
    @Column(scale = 2)
    private Double price;

    @NotNull
    @ManyToOne
    private Customer customer;

    @NotNull
    @ManyToMany
    private List<Product> products;

    @PrePersist
    public void prePersist(){
        startDate = LocalDate.now();
    }
    @PreUpdate
    public void preUpdate(){
        endDate = LocalDate.now();
        isActive = false;
    }



}
