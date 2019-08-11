package pl.andrzejgolian.farfaraway.place;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String createPlace(@ModelAttribute("place") Place place, BindingResult bindingResult, Model model){
        System.out.println(bindingResult);
        if(place.getId() != null) {
            placeService.updatePlace(place);
        } else {
            placeService.createPlace(place);
        }

        return "redirect:/place/placeList";
    }

    @GetMapping("/updatePlaceForm/{placeId}")
    public String showPlaceFormForUpdate(@PathVariable Long placeId,
                                           Model model) throws RuntimeException {
        Place pl = placeService.findById(placeId);
        model.addAttribute("place", pl);

        return "/place/place-form";
    }

    @GetMapping("/{placeId}/placeDelete")
    public String deletePlace(@PathVariable("placeId") Long placeId){
        placeService.delete(placeId);

        return "redirect:/place/placeList";
    }

    @GetMapping("/{id}")
    String displayAddress(@PathVariable Long id, Model model) {
        Place place = placeService.findById(id);
        model.addAttribute("place", place);

        return "/place/place-details";
    }
}
