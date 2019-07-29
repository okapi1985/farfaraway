package pl.andrzejgolian.farfaraway.holiday;

import pl.andrzejgolian.farfaraway.City.City;
import pl.andrzejgolian.farfaraway.airport.Airport;
import pl.andrzejgolian.farfaraway.hotel.Hotel;

public class Destination {

    private City city;
    private Hotel hotel;
    private Airport airport;

    public Destination(City city, Hotel hotel, Airport airport) {
        this.city = city;
        this.hotel = hotel;
        this.airport = airport;
    }

    public Destination() {}

    @Override
    public String toString() {
        return "Destination{" +
                "city=" + city +
                ", hotel=" + hotel +
                ", airport=" + airport +
                '}';
    }
}
