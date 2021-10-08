package co.vinod.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private String customerId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private Address address;
    private String phone;
    private String fax;
}
