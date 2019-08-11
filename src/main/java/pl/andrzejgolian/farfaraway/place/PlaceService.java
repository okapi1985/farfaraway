package pl.andrzejgolian.farfaraway.place;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceService {

    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public void createPlace(Place place) {
        placeRepository.save(place);
    }

    @Transactional
    public void delete(long placeId) {
        placeRepository.deleteById(placeId);
    }

    public Place findById(Long id) {

        return placeRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono miejsca"));
    }

    public Place updatePlace(Place place) {
        Place placeToUpdate = findById(place.getId());

        placeToUpdate.setHotel(place.getHotel());
        placeToUpdate.setDescription(place.getDescription());

        return placeRepository.save(placeToUpdate);
    }
}
