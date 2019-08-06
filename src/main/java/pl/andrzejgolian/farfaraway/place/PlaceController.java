package pl.andrzejgolian.farfaraway.place;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/placeList")
    public String listPlaces(Model model){
        List<Place> placeList = placeService.getPlaces();
        model.addAttribute("places",placeList);

        return "/place/place-list";
    }

    @GetMapping("/showPlaceForm")
    public String showPlacesForm(Model model){
        Place place = new Place();
        model.addAttribute("place",place);

        return "/place/place-form";
    }

    @PostMapping("/createPlace")
    public String createPlace(@ModelAttribute Place place, BindingResult bindingResult){

        placeService.createPlace(place);

        return "redirect:/place/placeList";
    }

    @GetMapping("/updatePlaceForm")
    public String showPlaceFormForUpdate(@RequestParam("placeId") long placeId,
                                           Model model) throws ItemNotFoundException {
        Place place = placeService.getPlace(placeId);
        model.addAttribute("place", place);

        return "/place/place-form";
    }

    @GetMapping("/placeDelete")
    public String deletePlace(@RequestParam("placeId") long placeId){
        placeService.delete(placeId);

        return "redirect:/place/placeList";
    }
}
