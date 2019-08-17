package pl.andrzejgolian.farfaraway.holidayCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.andrzejgolian.farfaraway.holiday.Holiday;

@Controller
public class PrintCartController {

    private HolidayCart holidayCart;

    @Autowired
    public PrintCartController(HolidayCart holidayCart) {
        this.holidayCart = holidayCart;
    }

    @GetMapping("/print")
    public String printHolidays(){
        for (Holiday holiday: holidayCart.getPurchasedHoliday()){
            System.out.println(holiday);
        }
        return "/main/cart";
    }
}
