package pl.andrzejgolian.farfaraway.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.andrzejgolian.farfaraway.holiday.HolidayService;

@Controller
public class GeneralController {

    private HolidayService holidayService;

    public GeneralController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @RequestMapping("/farfaraway")
    public String home() {

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

    @RequestMapping("/intro")
    public String intro(){

        return "/main/intro";
    }
}
