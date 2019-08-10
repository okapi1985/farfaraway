package pl.andrzejgolian.farfaraway.customer;

import pl.andrzejgolian.farfaraway.purchase.HolidayPurchase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer")
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    private List<HolidayPurchase> holidayPurchases;

    public Customer(String firstName, String lastName, Integer age, String email, String password, List<HolidayPurchase> holidayPurchases) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", holidayPurchases=" + holidayPurchases +
                '}';
    }
}
