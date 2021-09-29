package co.vinod.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    private Order order;

    public LineItem(Integer oderId, Integer productId) {
        this.oderId = oderId;
        this.productId = productId;
    }
}
