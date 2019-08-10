package pl.andrzejgolian.farfaraway.holiday;

import org.springframework.format.annotation.DateTimeFormat;
import pl.andrzejgolian.farfaraway.address.Address;
import pl.andrzejgolian.farfaraway.place.Place;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "holidays")
public class Holiday implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_holiday")
    private Long id;

    @Column(nullable = false)
    private Double adultPrice;

    @Column(nullable = false)
    private Double childPrice;

    @Column
    private Boolean promoted;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate flightDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    @Column(nullable = false)
    private Integer daysAmount;

    @Column(name = "board_type")
    @Enumerated(EnumType.STRING)
    private Board board;

    @Column(nullable = false)
    private Integer adultAmount;

    @Column
    private Integer childAmount;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToOne
    private Place place;

    public Holiday(Double adultPrice, Double childPrice, Boolean promoted, LocalDate flightDate, LocalDate returnDate,
                   Integer daysAmount, Board board, Integer adultAmount, Integer childAmount,
                   Address address, Place place) {
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.promoted = promoted;
        this.flightDate = flightDate;
        this.returnDate = returnDate;
        this.daysAmount = daysAmount;
        this.board = board;
        this.adultAmount = adultAmount;
        this.childAmount = childAmount;
        this.address = address;
        this.place = place;
    }

    public Holiday() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Double childPrice) {
        this.childPrice = childPrice;
    }

    public Boolean getPromoted() {
        return promoted;
    }

    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(Integer daysAmount) {
        this.daysAmount = daysAmount;
    }

    public Integer getAdultAmount() {
        return adultAmount;
    }

    public void setAdultAmount(Integer adultAmount) {
        this.adultAmount = adultAmount;
    }

    public Integer getChildAmount() {
        return childAmount;
    }

    public void setChildAmount(Integer childAmount) {
        this.childAmount = childAmount;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", adultPrice=" + adultPrice +
                ", childPrice=" + childPrice +
                ", promoted=" + promoted +
                ", flightDate=" + flightDate +
                ", returnDate=" + returnDate +
                ", daysAmount=" + daysAmount +
                ", board=" + board +
                ", adultAmount=" + adultAmount +
                ", childAmount=" + childAmount +
                ", address=" + address +
                ", place=" + place +
                '}';
    }
}
