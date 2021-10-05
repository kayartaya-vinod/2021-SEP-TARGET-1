package co.vinod.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable // an object of this class can be used as an embedded member of an entity class
public class Address {
    @Column(name="ADDRESS")
    private String street;
    private String city;
    private String region;
    @Column(name="POSTAL_CODE")
    private String postalCode;
    private String country;
}
