package pl.andrzejgolian.farfaraway.address;

import pl.andrzejgolian.farfaraway.holiday.Holiday;
import pl.andrzejgolian.farfaraway.place.Place;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Continent continent;
    private String country;
    private String city;
    private String airport;

    @OneToMany
    @JoinColumn(name = "address_id", referencedColumnName = "id_address")
    private List<Holiday> holidays;

    @OneToMany
    @JoinColumn(name = "address_id", referencedColumnName = "id_address")
    private List<Place> places;

    public Address(Continent continent, String country, String city, String airport, List<Holiday> holidays, List<Place> places) {
        this.continent = continent;
        this.country = country;
        this.city = city;
        this.airport = airport;
        this.holidays = holidays;
        this.places = places;
    }

    public Address() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return continent+", "
                +country+", "
                +city+", "
                +airport+".";
    }
}
