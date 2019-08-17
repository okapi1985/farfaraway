package pl.andrzejgolian.farfaraway.holidayCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.andrzejgolian.farfaraway.holiday.Holiday;

@Controller
public class AddCartController {

    private HolidayCart holidayCart;

    @Autowired
    public AddCartController(HolidayCart holidayCart) {
        this.holidayCart = holidayCart;
    }

    @PostMapping("/add")
    public String addHoliday(@RequestParam Holiday holiday){
        holidayCart.addHoliday(holiday);
        return "/main/cart";
    }
}
