package hasan.mohamed.shehata.sampleemps.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.*;

/**
 * The entity allowing interaction with the restaurants table.
 */
@ApiModel(value = "Employee",
        description = "Yes an actual employee record")
@Entity
@Table(name = "employees")
//@JsonIgnoreProperties(value = "hasvalueforseatcapacity") // never comes in from client!
public class Employee extends Auditable {

    /*
    Value Validation
    @Email(message = "must be a valid email") forces the field to be in a valid email format (username@domain.toplevel). If not, a message for "must be a valid email" is returned.
    @Size(min = ??, max = ??) restricts the size of a String field.
    @Min(value = ??) minimum value of an integer. Often used in conjunction with @Max
    @Max(value = ??) maximum value of an integer. Often used in conjunction with @Min
    @DecimalMin(value = "??.??") minimum value for doubles
    @DecimalMax(value = "??.??") maximum value for doubles
    @Postive must be a positive number
    @Negative must be a negative number
    @NotNull another way to validate whether a field can be null or not
    @Future date must be in the future
    @Pattern(value = "regex") allows you specific a regex pattern to use to validate the data! Discussing regex patterns are beyond the scope of this module. See additional resources for more information.

     */
    @ApiModelProperty(name = "employee name",
            value = "full name of employee",
            required = true,
            example = "Best Employee")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeid;

    @ApiModelProperty(name = "employee name",
            value = "full name of employee",
            required = true,
            example = "Best Employee")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("employee")
    private List<Email> emails = new ArrayList<>();


    @ManyToMany()
    @JoinTable(name = "employeetitles",
            joinColumns = @JoinColumn(name = "employeeid"),
            inverseJoinColumns = @JoinColumn(name = "jobtitleid"))
    @JsonIgnoreProperties("employees")
    Set<Jobtitle> jobtitles = new HashSet<>();

    @ApiModelProperty(name = "employee name",
            value = "salary of employee",
            required = false,
            example = "100000")
    @DecimalMax(value = "25000.0", message = "Salary cannot exceed 25,000$/Month")
    @DecimalMin(value = "0.0", message = "Salary must be a positive number")
    private double salary;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }


    public long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(long employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Set<Jobtitle> getJobtitles() {
        return jobtitles;
    }

    public void setJobtitles(Set<Jobtitle> jobtitles) {
        this.jobtitles = jobtitles;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
