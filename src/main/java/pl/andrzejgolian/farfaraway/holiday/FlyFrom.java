package pl.andrzejgolian.farfaraway.holiday;

import pl.andrzejgolian.farfaraway.City.City;
import pl.andrzejgolian.farfaraway.airport.Airport;

public class FlyFrom {

    private City city;
    private Airport airport;

    public FlyFrom(City city, Airport airport) {
        this.city = city;
        this.airport = airport;
    }

    public FlyFrom() {}

    @Override
    public String toString() {
        return "FlyFrom{" +
                "city=" + city +
                ", airport=" + airport +
                '}';
    }
}
