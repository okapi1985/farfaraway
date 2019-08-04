package pl.andrzejgolian.farfaraway.purchase;

import pl.andrzejgolian.farfaraway.customer.Customer;
import pl.andrzejgolian.farfaraway.holiday.Holiday;

import javax.persistence.*;

@Entity
@Table(name = "holiday_purchases")
public class HolidayPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_holiday_purchase")
    private Long id;

    private Double totalAmount;

    @OneToOne
    private Holiday holiday;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public HolidayPurchase(Double totalAmount, Holiday holiday, Customer customer) {
        this.totalAmount = totalAmount;
        this.holiday = holiday;
        this.customer = customer;
    }

    public HolidayPurchase() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "HolidayPurchase{" +
                "id=" + id +
                ", totalAmount=" + totalAmount +
                ", holiday=" + holiday +
                ", customer=" + customer +
                '}';
    }
}
