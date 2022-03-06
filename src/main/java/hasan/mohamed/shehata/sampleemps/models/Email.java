package hasan.mohamed.shehata.sampleemps.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The entity allowing interaction with the restaurants table.
 */
@Entity
@Table(name = "emails")
//@JsonIgnoreProperties(value = "hasvalueforseatcapacity") // never comes in from client!
public class Email extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailid;

    @javax.validation.constraints.Email
    @Column(unique = true,
            nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "employeeid",
            nullable = false)
    @JsonIgnoreProperties("emails")
    private Employee employee;

    public Email() {
    }

    public Email(String email, Employee employee) {
        this.email = email;
        this.employee = employee;
    }

    public long getEmailid() {
        return emailid;
    }

    public void setEmailid(long emailid) {
        this.emailid = emailid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
