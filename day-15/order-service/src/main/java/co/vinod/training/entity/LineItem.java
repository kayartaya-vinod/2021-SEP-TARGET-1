package co.vinod.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="ORDER_DETAILS")
public class LineItem implements Serializable {
    @Id
    @Column(name="ORDER_ID")
    private Integer orderId;

    @Id
    @Column(name="PRODUCT_ID")
    private Integer productId;

    private Integer quantity;
    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    private Double discount;
}
