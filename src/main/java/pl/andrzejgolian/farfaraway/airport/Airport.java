package pl.andrzejgolian.farfaraway.airport;

import javax.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String airportName;

    @Column(nullable = false)
    private Long cityId;

    public Airport(String airportName, Long cityId) {
        this.airportName = airportName;
        this.cityId = cityId;
    }

    public Airport() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", airportName='" + airportName + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
