package pl.andrzejgolian.farfaraway.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.andrzejgolian.farfaraway.holiday.Holiday;
import pl.andrzejgolian.farfaraway.holiday.HolidayService;

import java.util.List;

@Controller
public class GeneralController {

    private HolidayService holidayService;

    public GeneralController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @RequestMapping("/farfaraway")
    public String home(@RequestParam(required = false) String phrase, Model model) {
//        if (phrase == null || phrase.isEmpty()){
//            List<Holiday> holidayList = holidayService.getHolidays();
//            model.addAttribute("holidays", holidayList);
//        } else {
//            List<Holiday> holidayList = holidayService.search(phrase);
//            model.addAttribute("holidays", holidayList);
//        }

        return "/main/main";
    }

    @RequestMapping("/admin")
    public String admin() {

        return "/main/admin";
    }

    @RequestMapping("/main/registration")
    public String registration() {

        return "/main/registration";
    }
}
