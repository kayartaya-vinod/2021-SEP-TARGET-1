package co.vinod.training.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ORDER_DETAILS")
public class LineItem implements Serializable {
    @Id
    @Column(name = "ORDER_ID")
    private Integer oderId;
    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    private Integer quantity;
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
    private Product product;
}
