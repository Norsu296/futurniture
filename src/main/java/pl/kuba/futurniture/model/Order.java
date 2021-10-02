package pl.kuba.futurniture.model;


import lombok.Data;

import javax.persistence.*;
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

    @NotNull
    @Column(name = "ship_date")
    private LocalDate shipDate;

    @NotNull
    @Column(name = "is_important")
    private boolean isImportant;

    @NotNull
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;

    @Column(scale = 2)
    private Double price;

    @NotNull
    @OneToMany
    private List<Customer>customers;

    @NotNull
    @OneToMany
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
