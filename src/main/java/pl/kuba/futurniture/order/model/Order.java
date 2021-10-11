package pl.kuba.futurniture.order.model;


import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.springframework.format.annotation.DateTimeFormat;
import pl.kuba.futurniture.customer.model.Customer;
import pl.kuba.futurniture.product.model.Product;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "orders")
@SQLDelete(sql = "UPDATE orders SET deleted = true WHERE id = ?")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "is_paid")
    private boolean isPaid;

    @Column(name = "start_date")
    private LocalDate startDate = LocalDate.now();

    @Column(name = "end_date")
    private LocalDate endDate;

    @NotNull
    @Future(message = "Data musi być z przyszłości")
    @Column(name = "ship_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate shipDate;

    @NotNull
    @Column(name = "is_important")
    private boolean isImportant;

    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    @NotNull
    @Column(scale = 2)
    private Double price;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Size(max = 250, message = "Opis nie może być dłuższy niż 250 znaków")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;


    private boolean deleted;

    @ManyToMany
    private List<Product> products;

    @PrePersist
    public void prePersist(){
        startDate = LocalDate.now();
        isActive = true;
        orderStatus = OrderStatus.accepted;
    }

}