package pl.andrzejgolian.farfaraway.hotel;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hotelName;
    private String hotelStandard;

    @Column(length = 2048)
    private String hotelDescription;
    private Long cityId;

    public Hotel(String hotelName, String hotelStandard, String hotelDescription, Long cityId) {
        this.hotelName = hotelName;
        this.hotelStandard = hotelStandard;
        this.hotelDescription = hotelDescription;
        this.cityId = cityId;
    }

    public Hotel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelStandard() {
        return hotelStandard;
    }

    public void setHotelStandard(String hotelStandard) {
        this.hotelStandard = hotelStandard;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelStandard='" + hotelStandard + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
