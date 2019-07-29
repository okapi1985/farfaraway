package pl.andrzejgolian.farfaraway.holiday;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private FlyFrom flyFrom;

    @Column(nullable = false)
    private Destination destination;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    @Column(nullable = false)
    private LocalDateTime arrivalDate;

    @Column(nullable = false)
    private Integer daysAmount;

    @Column(nullable = false)
    private Double adultPrice;

    @Column(nullable = false)
    private Double childPrice;

    @Column(nullable = false)
    private Boolean promoted;

    @Column(nullable = false)
    private Integer adultAmount;

    private Integer childAmount;

    public Holiday(FlyFrom flyFrom, Destination destination, LocalDateTime departureDate, LocalDateTime arrivalDate,
                   Integer daysAmount, Double adultPrice, Double childPrice,
                   Boolean promoted, Integer adultAmount, Integer childAmount) {
        this.flyFrom = flyFrom;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.daysAmount = daysAmount;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.promoted = promoted;
        this.adultAmount = adultAmount;
        this.childAmount = childAmount;
    }

    public Holiday() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlyFrom getFlyFrom() {
        return flyFrom;
    }

    public void setFlyFrom(FlyFrom flyFrom) {
        this.flyFrom = flyFrom;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getDaysAmount() {
        return daysAmount;
    }

    public void setDaysAmount(Integer daysAmount) {
        this.daysAmount = daysAmount;
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

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", flyFrom=" + flyFrom +
                ", destination=" + destination +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", daysAmount=" + daysAmount +
                ", adultPrice=" + adultPrice +
                ", childPrice=" + childPrice +
                ", promoted=" + promoted +
                ", adultAmount=" + adultAmount +
                ", childAmount=" + childAmount +
                '}';
    }
}
