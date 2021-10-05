package co.vinod.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMERS")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name="CUSTOMER_ID")
    private String customerId;
    @Column(name="COMPANY_NAME")
    private String companyName;
    @Column(name="CONTACT_NAME")
    private String contactName;
    @Column(name="CONTACT_TITLE")
    private String contactTitle;
    @Embedded
    private Address address;
    private String phone;
    private String fax;
//    @Transient
//    private String email; // attempts to map to an existing column; to avoid this, use @Transient annotation
}
