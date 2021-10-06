package co.vinod.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEES")
public class Employee {
    @Id
    @Column(name="EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastname;
    private String title;
    @Column(name="TITLE_OF_COURTESY")
    private String titleOfCourtesy;
    @Column(name="BIRTH_DATE")
    private Date birthDate;
    @Column(name="HIRE_DATE")
    private Date hireDate;

    @Embedded
    private Address address; // address, city, region, postal_code, country

    @Column(name="HOME_PHONE")
    private String homePhone;
    private String extension;
    @JsonIgnore
    private byte[] photo;
    private String notes;

    @ManyToOne
    @JoinColumn(name="REPORTS_TO")
    private Employee manager; // reports_to
}
