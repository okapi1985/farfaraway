package pl.andrzejgolian.farfaraway.holiday;

import javax.persistence.*;

@Entity
public class HolidayPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Holiday holiday;

    @Column(nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private Long totalAmount;

    @Column(nullable = false)
    private Long holidayId;

    public HolidayPurchase(Holiday holiday, Customer customer, Long totalAmount, Long holidayId) {
        this.holiday = holiday;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.holidayId = holidayId;
    }

    public HolidayPurchase() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Long holidayId) {
        this.holidayId = holidayId;
    }

    @Override
    public String toString() {
        return "HolidayPurchase{" +
                "id=" + id +
                ", holiday=" + holiday +
                ", customer=" + customer +
                ", totalAmount=" + totalAmount +
                ", holidayId=" + holidayId +
                '}';
    }
}
