package pl.andrzejgolian.farfaraway.place;

import pl.andrzejgolian.farfaraway.address.Address;
import pl.andrzejgolian.farfaraway.holiday.Holiday;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_place")
    private Long id;

    private String hotel;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToOne
    private Holiday holiday;

    public Place(String hotel, String description, Address address, Holiday holiday) {
        this.hotel = hotel;
        this.description = description;
        this.address = address;
        this.holiday = holiday;
    }

    public Place() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", hotel='" + hotel + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", holiday=" + holiday +
                '}';
    }
}
