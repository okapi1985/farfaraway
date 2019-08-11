package pl.andrzejgolian.farfaraway.holiday;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.andrzejgolian.farfaraway.address.AddressRepository;
import pl.andrzejgolian.farfaraway.place.Place;
import pl.andrzejgolian.farfaraway.place.PlaceRepository;

import java.util.List;

@Controller
@RequestMapping("/holiday")
public class HolidayController {

    private final HolidayService holidayService;
    private final AddressRepository addressRepository;
    private final PlaceRepository placeRepository;

    public HolidayController(HolidayService holidayService, AddressRepository addressRepository, PlaceRepository placeRepository) {
        this.holidayService = holidayService;
        this.addressRepository = addressRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/list")
    public String listHolidays(Model model) {
        List<Holiday> holidayList = holidayService.getHolidays();
        model.addAttribute("holidays", holidayList);

        return "/holiday/holiday-list";
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        Holiday holiday = new Holiday();
        model.addAttribute("holiday", holiday);
        model.addAttribute("addresses", addressRepository.findAll());
        model.addAttribute("places", placeRepository.findAll());

        return "/holiday/holiday-form";
    }

    @PostMapping("/createHoliday")
    public String createHoliday(@ModelAttribute("holiday") Holiday holiday, BindingResult bindingResult, Model model){
        System.out.println(bindingResult);
        if(holiday.getId() != null) {
            holidayService.updateHoliday(holiday);
        } else {
            holidayService.create(holiday);
        }

        return "redirect:/holiday/list";
    }

    @GetMapping("/updateForm/{holidayId}")
    public String showFormForUpdate(@PathVariable Long holidayId,
                                    Model model) throws RuntimeException{
        Holiday hol = holidayService.findById(holidayId);
        model.addAttribute("holiday", hol);

        model.addAttribute("addresses", addressRepository.findAll());
        model.addAttribute("places", placeRepository.findAll());
        return "/holiday/holiday-form";
    }

    @GetMapping("/{holidayId}/delete")
    public String deleteHoliday(@PathVariable("holidayId") Long holidayId){
        holidayService.delete(holidayId);

        return "redirect:/holiday/list";
    }

    @GetMapping("/{id}")
    String displayHoliday(@PathVariable Long id, Model model) {
        Holiday holiday = holidayService.findById(id);
        model.addAttribute("holiday", holiday);

        return "/holiday/holiday-details";
    }

}
