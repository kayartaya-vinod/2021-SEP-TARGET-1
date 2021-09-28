package co.vinod.training.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "QUANTITY_PER_UNIT")
    private String quantityPerUnit;
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;
    @Column(name = "UNITS_IN_STOCK")
    private Integer unitsInStock;
    @Column(name = "UNITS_ON_ORDER")
    private Integer unitsOnOrder;
    @Column(name = "REORDER_LEVEL")
    private Integer reorderLevel;
    private Integer discontinued;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

}
