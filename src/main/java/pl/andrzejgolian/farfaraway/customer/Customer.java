package pl.andrzejgolian.farfaraway.customer;

import pl.andrzejgolian.farfaraway.purchase.HolidayPurchase;
import pl.andrzejgolian.farfaraway.role.CustomerRole;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer")
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dob;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<CustomerRole> roles = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private List<HolidayPurchase> holidayPurchases;

    public Customer(String firstName, String lastName, LocalDate dob, String email, String password,
                    Set<CustomerRole> roles, List<HolidayPurchase> holidayPurchases) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.holidayPurchases = holidayPurchases;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<HolidayPurchase> getHolidayPurchases() {
        return holidayPurchases;
    }

    public void setHolidayPurchases(List<HolidayPurchase> holidayPurchases) {
        this.holidayPurchases = holidayPurchases;
    }

    public Set<CustomerRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<CustomerRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", holidayPurchases=" + holidayPurchases +
                '}';
    }
}
