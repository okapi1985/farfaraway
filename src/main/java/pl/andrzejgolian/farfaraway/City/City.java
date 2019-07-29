package pl.andrzejgolian.farfaraway.City;

import javax.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String cityName;

    @Column(nullable = false)
    private Long countryId;

    public City(String cityName, Long countryId) {
        this.cityName = cityName;
        this.countryId = countryId;
    }

    public City() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
