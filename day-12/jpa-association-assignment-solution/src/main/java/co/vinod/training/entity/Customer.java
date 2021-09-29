package co.vinod.training.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="CUSTOMERS")
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
    private String address;
    private String city;
    private String region;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
}
