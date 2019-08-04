package pl.andrzejgolian.farfaraway.place;

import org.springframework.stereotype.Service;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

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

    public Place getPlace(long placeId) throws ItemNotFoundException {
        return placeRepository.findById(placeId)
                .orElseThrow(() -> new ItemNotFoundException(placeId));
    }

    public void delete(long placeId) {
        placeRepository.deleteById(placeId);
    }
}
