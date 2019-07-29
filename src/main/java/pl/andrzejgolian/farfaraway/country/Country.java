package pl.andrzejgolian.farfaraway.country;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String countryName;

    private Continent continent; //Czy enum musi mieć klucz obcy?

    public Country(String countryName, Continent continent) {
        this.countryName = countryName;
        this.continent = continent;
    }

    public Country() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", continent=" + continent +
                '}';
    }
}
