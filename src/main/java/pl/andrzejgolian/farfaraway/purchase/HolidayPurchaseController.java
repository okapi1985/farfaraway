package pl.andrzejgolian.farfaraway.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.andrzejgolian.farfaraway.holiday.HolidayService;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class HolidayPurchaseController {

    private final HolidayPurchaseService holidayPurchaseService;
    private final HolidayService holidayService;

    @Autowired
    public HolidayPurchaseController(HolidayPurchaseService holidayPurchaseService, HolidayService holidayService) {
        this.holidayPurchaseService = holidayPurchaseService;
        this.holidayService = holidayService;
    }

}
