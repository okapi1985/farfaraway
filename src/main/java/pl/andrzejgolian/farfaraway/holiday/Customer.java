package pl.andrzejgolian.farfaraway.holiday;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private Long holidayPurchaseId; //czy konieczny jest tu klucz?

    public Customer(String firstName, String lastName, String age, Long holidayPurchaseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.holidayPurchaseId = holidayPurchaseId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getHolidayPurchaseId() {
        return holidayPurchaseId;
    }

    public void setHolidayPurchaseId(Long holidayPurchaseId) {
        this.holidayPurchaseId = holidayPurchaseId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", holidayPurchaseId=" + holidayPurchaseId +
                '}';
    }
}
