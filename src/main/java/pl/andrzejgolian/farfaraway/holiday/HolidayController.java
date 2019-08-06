package pl.andrzejgolian.farfaraway.holiday;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/holiday")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
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

        return "/holiday/holiday-form";
    }

    @PostMapping("/createHoliday")
    public String createHoliday(@ModelAttribute("holiday") Holiday holiday, BindingResult bindingResult){
        System.out.println(bindingResult);

        holidayService.create(holiday);

        return "redirect:/holiday/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@ModelAttribute("holiday") Holiday holiday,
                                    Model model) throws ItemNotFoundException{
        Holiday cH = holidayService.getHoliday(holiday.getId());
        model.addAttribute("holiday", cH);

        return "/holiday/holiday-form";
    }

    @GetMapping("/delete")
    public String deleteHoliday(@RequestParam("holidayId") int holidayId){
        holidayService.delete(holidayId);

        return "redirect:/holiday/list";
    }

//    @GetMapping("/{id}")
//    String displayHoliday(@PathVariable Long id, Model model) {
//        Holiday holiday = holidayService.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Holiday not found"));
//        model.addAttribute("holiday", holiday);
//
//        return "/holiday/holiday-details";
//    }

}
