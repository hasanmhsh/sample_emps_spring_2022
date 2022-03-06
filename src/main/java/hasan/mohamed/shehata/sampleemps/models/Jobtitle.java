package hasan.mohamed.shehata.sampleemps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the restaurants table.
 */
@Entity
@Table(name = "jobtitles")
//@JsonIgnoreProperties(value = "hasvalueforseatcapacity") // never comes in from client!

public class Jobtitle extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobtitleid;

    /**
     * The type (String) of payment. Cannot be null and must be unique.
     */
    @Column(nullable = false,
            unique = true)
    private String title;

    /**
     * Creates a join table joining Restaurants and Payments in a Many-To-Many relations.
     * Contains a Set of Restaurant Objects using this Payment method.
     */
    @ManyToMany(mappedBy = "jobtitles")
    @JsonIgnoreProperties("jobtitles")
    private Set<Employee> employees = new HashSet<>();

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Jobtitle()
    {
    }

    public Jobtitle(String title) {
        this.title = title;
    }

    public long getJobtitleid() {
        return jobtitleid;
    }

    public void setJobtitleid(long jobtitleid) {
        this.jobtitleid = jobtitleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
