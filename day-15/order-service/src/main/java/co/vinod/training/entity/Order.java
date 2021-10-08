package co.vinod.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="ORDERS")
@NoArgsConstructor
public class Order {
    @Id
    @Column(name="ORDER_ID")
    private Integer orderId;

    @JsonIgnore
    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Transient // JPA doesn't care about this
    private Customer customer;

    @Column(name="ORDER_DATE")
    private Date orderDate;
    @Column(name="REQUIRED_DATE")
    private Date requiredDate;
    @Column(name="SHIPPED_DATE")
    private Date shippedDate;
    private Double freight;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private List<LineItem> items;

}
